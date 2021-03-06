package com.concise.query.core;

import com.concise.query.entity.Persistable;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import javax.persistence.Id;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import static com.concise.query.core.QueryBuilder.ignoreField;
import static com.concise.query.core.QueryBuilder.readField;

@Slf4j
public abstract class AbstractMockDataAccess<E extends Persistable<I>, I extends Serializable, Q> implements DataAccess<E, I, Q> {
    protected static final Map<String, Map> tableMap = new ConcurrentHashMap<>();
    private static final String SUFFIX_LIKE = "Like";
    protected final Map<I, E> entitiesMap = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    public AbstractMockDataAccess(String table) {
        tableMap.put(table, entitiesMap);
    }

    protected void generateNewId(E entity) {
        Field[] fields = FieldUtils.getAllFields(entity.getClass());
        for (Field field : fields) {
            if (field.isAnnotationPresent(Id.class)) {
                try {
                    Object newId = chooseIdValue(idGenerator.incrementAndGet(), field.getType());
                    FieldUtils.writeField(field, entity, newId, true);
                } catch (Exception e) {
                    log.warn("写入id失败: {} - {}", entity.getClass(), e.getMessage());
                }
                break;
            }
        }
    }

    private Object chooseIdValue(Long newId, Class<?> type) {
        Object t = newId;
        if (type.isAssignableFrom(Integer.class)) {
            t = newId.intValue();
        }
        return t;
    }

    @Override
    public E get(I id) {
        return entitiesMap.get(id);
    }

    @Override
    public void create(E e) {
        generateNewId(e);
        entitiesMap.put(e.getId(), e);
    }

    @Override
    public void update(E e) {
        entitiesMap.put(e.getId(), e);
    }

    @Override
    public void delete(I id) {
        entitiesMap.remove(id);
    }

    protected boolean filterByQuery(Q query, E entity) {
        for (Field field : query.getClass().getDeclaredFields()) {
            if (!ignoreField(field)) {
                Object v1 = readField(field, query);
                if (v1 != null && unsatisfied(entity, field.getName(), v1)) {
                    return false;
                }
            }
        }
        return true;
    }

    protected boolean unsatisfied(E entity, String fieldName, Object v1) {
        Object v2;
        String suffix = "";
        if (fieldName.endsWith(SUFFIX_LIKE)) {
            fieldName = fieldName.substring(0, fieldName.length() - 4);
            suffix = SUFFIX_LIKE;
        }
        // only do filter when there is a corresponding field in the entity
        if (FieldUtils.getField(entity.getClass(), fieldName, true) != null) {
            if (suffix.equals(SUFFIX_LIKE)) {
                v2 = readField(entity, fieldName);
                return v2 != null && !StringUtils.contains(v2.toString(), v1.toString());
            } else {
                v2 = readField(entity, fieldName);
                return !v1.equals(v2);
            }
        }
        return false;
    }

    @Override
    public List<E> query(Q query) {
        List<E> queryList = entitiesMap
                .values().stream()
                .filter(item -> filterByQuery(query, item))
                .collect(Collectors.toList());

        if (query instanceof PageQuery) {
            PageQuery pageQuery = (PageQuery) query;
            if (pageQuery.needPaging()) {
                int from = pageQuery.getPageNumber() * pageQuery.getPageSize();
                int end = Math.min(queryList.size(), from + pageQuery.getPageSize());
                if (from <= end) {
                    queryList = new ArrayList<>(queryList.subList(from, end));
                }
            }
        }

        return queryList;
    }

    @Override
    public long count(Q query) {
        return entitiesMap.values().stream()
                .filter(item -> filterByQuery(query, item)).count();
    }

    public void reset() {
        entitiesMap.clear();
        idGenerator.set(0);
    }
}
