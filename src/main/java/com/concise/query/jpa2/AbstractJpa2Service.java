package com.concise.query.jpa2;

import com.concise.query.core.AbstractService;
import com.concise.query.entity.Persistable;
import org.springframework.data.repository.CrudRepository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import java.io.Serializable;

public class AbstractJpa2Service<E extends Persistable<I>, I extends Serializable, Q> extends AbstractService<E, I, Q> {

    public AbstractJpa2Service(CrudRepository<E, I> crudRepository) {
        super(new Jpa2DataAccess<>(crudRepository));
    }

    @Resource
    public void setEntityManager(EntityManager entityManager) {
        ((Jpa2DataAccess) dataAccess).setEntityManager(entityManager);
    }
}
