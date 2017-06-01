package io.hexagon.repository.ebean;

import io.ebean.EbeanServer;
import io.ebean.OrderBy;
import io.ebean.PagedList;
import org.springframework.data.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Xuegui Yuan
 */
public class EbeanPagingAndSortingRepository<T, ID extends Serializable> extends EbeanCurdRepository<T, ID> implements PagingAndSortingRepository<T, ID> {

    public EbeanPagingAndSortingRepository(EbeanServer ebeanServer, Class<T> entityType) {
        super(ebeanServer, entityType);
    }

    @Override
    public Iterable<T> findAll(Sort sort) {
        return currentDb().find(getEntityType()).setOrder(ebeanOrderFromSpringDataSort(sort)).findList();
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return springDataPageFromEbeanPageList(currentDb().find(getEntityType()).setMaxRows(pageable.getPageSize()).setFirstRow(pageable.getOffset()).findPagedList());
    }

    protected OrderBy<T> ebeanOrderFromSpringDataSort(Sort sort) {
        List<String> list = new ArrayList<>();
        while (sort.iterator().hasNext()) {
            Sort.Order so = sort.iterator().next();
            list.add(so.getDirection() == Sort.Direction.ASC ? so.getProperty() + " asc" : so.getProperty() + " desc");
        }
       return new OrderBy<T>(StringUtils.collectionToCommaDelimitedString(list));
    }

    protected Page<T> springDataPageFromEbeanPageList(PagedList pagedList) {
        return new PageImpl<T>(pagedList.getList(),
                new PageRequest(pagedList.getPageIndex(), pagedList.getPageSize()),
                pagedList.getTotalCount());
    }
}
