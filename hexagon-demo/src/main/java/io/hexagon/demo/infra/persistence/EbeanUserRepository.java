package io.hexagon.demo.infra.persistence;

import io.ebean.EbeanServer;
import io.hexagon.demo.domain.model.User;
import io.hexagon.demo.domain.model.UserRepository;
import io.hexagon.repository.ebean.EbeanPagingAndSortingRepository;
import io.hexagon.repository.ebean.EbeanSelectableRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Xuegui Yuan
 */
@Repository
public class EbeanUserRepository extends EbeanSelectableRepository<User, Long> implements UserRepository {
    public EbeanUserRepository(EbeanServer ebeanServer) {
        super(ebeanServer, User.class);
    }
}
