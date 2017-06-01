package io.hexagon.repository.ebean;

import io.ebean.EbeanServer;
import io.hexagon.repository.DbChangeable;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author Xuegui Yuan
 */
public abstract class EbeanCurdRepository<T, ID extends Serializable> implements CrudRepository<T, ID>, DbChangeable {
    private EbeanServer ebeanServer;
    private Class<T> entityType;

    public EbeanCurdRepository(EbeanServer ebeanServer, Class<T> entityType) {
        this.ebeanServer = ebeanServer;
        this.entityType = entityType;
    }

    public EbeanServer currentDb() {
        return ebeanServer;
    }

    @Override
    public void db(Object db) {
        this.ebeanServer = (EbeanServer)db;
    }

    public Class<T> getEntityType() {
        return entityType;
    }

    public void setEntityType(Class<T> entityType) {
        this.entityType = entityType;
    }

    @Override
    public <S extends T> S save(S s) {
        currentDb().save(s);
        return s;
    }

    @Override
    public <S extends T> Iterable<S> save(Iterable<S> iterable) {
        currentDb().saveAll((Collection<?>)iterable);
        return iterable;
    }

    @Override
    public T findOne(ID id) {
        return currentDb().find(getEntityType()).where().idEq(id).findUnique();
    }

    @Override
    public boolean exists(ID id) {
        return currentDb().find(getEntityType()).where().idEq(id).findCount() > 0;
    }

    @Override
    public Iterable<T> findAll() {
        return currentDb().find(getEntityType()).where().findList();
    }

    @Override
    public Iterable<T> findAll(Iterable<ID> ids) {
        return currentDb().find(getEntityType()).where().idIn(ids).findList();
    }

    @Override
    public long count() {
        return currentDb().find(getEntityType()).findCount();
    }

    @Override
    public void delete(ID id) {
        currentDb().find(getEntityType()).where().idEq(id).delete();
    }

    @Override
    public void delete(T t) {
        currentDb().delete(t);
    }

    @Override
    public void delete(Iterable<? extends T> iterable) {
        currentDb().deleteAll((Collection<?>)iterable);
    }

    @Override
    public void deleteAll() {
        currentDb().find(getEntityType()).delete();
    }
}
