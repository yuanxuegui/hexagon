package io.hexagon.demo.domain.model;

import io.hexagon.repository.DbChangeable;
import io.hexagon.repository.SelectableRepository;

/**
 * @author Xuegui Yuan
 */
public interface UserRepository extends SelectableRepository<User, Long>, DbChangeable {

}
