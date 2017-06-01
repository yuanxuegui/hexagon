package io.hexagon.demo.infra.persistence;

import io.ebean.EbeanServer;
import io.hexagon.demo.domain.model.User;
import io.hexagon.demo.domain.model.UserRepository;
import io.hexagon.repository.ebean.EbeanPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Xuegui Yuan
 */
@Repository
public class EbeanUserRepository extends EbeanPagingAndSortingRepository<User, Long> implements UserRepository {
    public EbeanUserRepository(EbeanServer ebeanServer) {
        super(ebeanServer, User.class);
    }
}
