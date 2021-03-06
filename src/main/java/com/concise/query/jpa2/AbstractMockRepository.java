package com.concise.query.jpa2;

import com.concise.query.core.AbstractMockDataAccess;
import com.concise.query.core.QueryService;
import com.concise.query.entity.Persistable;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.Optional;

public class AbstractMockRepository<E extends Persistable<I>, I extends Serializable, Q>
        extends AbstractMockDataAccess<E, I, Q>
        implements CrudRepository<E, I>, QueryService<E, Q> {

    public AbstractMockRepository(String table) {
        super(table);
    }

    @Override
    public <S extends E> S save(S s) {
        if (s.isNew()) {
            generateNewId(s);
        }
        entitiesMap.put(s.getId(), s);
        return s;
    }

    @Override
    public <S extends E> Iterable<S> saveAll(Iterable<S> entities) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<E> findById(I id) {
        return Optional.ofNullable(entitiesMap.get(id));
    }

    @Override
    public boolean existsById(I id) {
        return entitiesMap.containsKey(id);
    }

    @Override
    public Iterable<E> findAll() {
        return entitiesMap.values();
    }

    @Override
    public Iterable<E> findAllById(Iterable<I> ids) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long count() {
        return entitiesMap.size();
    }

    @Override
    public void deleteById(I id) {
        entitiesMap.remove(id);
    }

    public void delete(E e) {
        entitiesMap.remove(e.getId());
    }

    @Override
    public void deleteAll(Iterable<? extends E> iterable) {
        iterable.forEach(this::delete);
    }

    @Override
    public void deleteAll() {
        entitiesMap.clear();
    }
}

