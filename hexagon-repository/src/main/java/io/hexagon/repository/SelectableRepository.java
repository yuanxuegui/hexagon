package io.hexagon.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * @author Xuegui Yuan
 */
public interface SelectableRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {
    T findOne(ID id, String selects);

    Iterable<T> findAll(String selects);

    Iterable<T> findAll(Iterable<ID> ids, String selects);

    Iterable<T> findAll(Sort sort, String selects);

    Page<T> findAll(Pageable pageable, String selects);
}
