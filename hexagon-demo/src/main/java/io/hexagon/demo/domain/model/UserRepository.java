package io.hexagon.demo.domain.model;

import io.hexagon.repository.DbChangeable;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Xuegui Yuan
 */
public interface UserRepository extends CrudRepository<User, Long>, DbChangeable {

}
