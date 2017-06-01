package io.hexagon.repository.ebean;

import io.ebean.EbeanServer;
import io.hexagon.repository.SelectableRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

/**
 * @author Xuegui Yuan
 */
public class EbeanSelectableRepository<T, ID extends Serializable> extends EbeanPagingAndSortingRepository<T, ID> implements SelectableRepository<T, ID> {

    public EbeanSelectableRepository(EbeanServer ebeanServer, Class<T> entityType) {
        super(ebeanServer, entityType);
    }

    @Override
    public T findOne(ID id, String selects) {
        return currentDb().find(getEntityType()).select(selects).where().idEq(id).findUnique();
    }

    @Override
    public Iterable<T> findAll(String selects) {
        return currentDb().find(getEntityType()).select(selects).findList();
    }

    @Override
    public Iterable<T> findAll(Iterable<ID> ids, String selects) {
        return currentDb().find(getEntityType()).select(selects).where().idIn(ids).findList();
    }

    @Override
    public Iterable<T> findAll(Sort sort, String selects) {
        return currentDb().find(getEntityType()).select(selects).setOrder(ebeanOrderFromSpringDataSort(sort)).findList();
    }

    @Override
    public Page<T> findAll(Pageable pageable, String selects) {
        return springDataPageFromEbeanPageList(currentDb().find(getEntityType()).select(selects).setMaxRows(pageable.getPageSize()).setFirstRow(pageable.getOffset()).findPagedList());
    }
}
