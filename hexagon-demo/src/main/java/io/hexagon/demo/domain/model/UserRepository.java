package io.hexagon.demo.domain.model;

import io.hexagon.repository.DbChangeable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Xuegui Yuan
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long>, DbChangeable {

}
