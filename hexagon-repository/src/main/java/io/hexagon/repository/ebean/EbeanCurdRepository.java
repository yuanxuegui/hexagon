package io.hexagon.repository.ebean;

import io.ebean.EbeanServer;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author Xuegui Yuan
 */
public abstract class EbeanCurdRepository<T, ID extends Serializable> implements CrudRepository<T, ID> {
    public abstract EbeanServer getEbeanServer();

    public abstract Class<T> getEntityClass();

    @Override
    public <S extends T> S save(S s) {
        getEbeanServer().save(s);
        return s;
    }

    @Override
    public <S extends T> Iterable<S> save(Iterable<S> iterable) {
        getEbeanServer().saveAll((Collection<?>)iterable);
        return iterable;
    }

    @Override
    public T findOne(ID id) {
        return getEbeanServer().find(getEntityClass()).where().idEq(id).findUnique();
    }

    @Override
    public boolean exists(ID id) {
        return getEbeanServer().find(getEntityClass()).where().idEq(id).findCount() > 0;
    }

    @Override
    public Iterable<T> findAll() {
        return getEbeanServer().find(getEntityClass()).where().findList();
    }

    @Override
    public Iterable<T> findAll(Iterable<ID> ids) {
        return getEbeanServer().find(getEntityClass()).where().idIn(ids).findList();
    }

    @Override
    public long count() {
        return getEbeanServer().find(getEntityClass()).findCount();
    }

    @Override
    public void delete(ID id) {
        getEbeanServer().find(getEntityClass()).where().idEq(id).delete();
    }

    @Override
    public void delete(T t) {
        getEbeanServer().delete(t);
    }

    @Override
    public void delete(Iterable<? extends T> iterable) {
        getEbeanServer().deleteAll((Collection<?>)iterable);
    }

    @Override
    public void deleteAll() {
        getEbeanServer().find(getEntityClass()).delete();
    }
}
