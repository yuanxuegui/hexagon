package io.hexagon.demo.infra.persistence;

import io.ebean.EbeanServer;
import io.hexagon.demo.domain.model.User;
import io.hexagon.demo.domain.model.UserRepository;
import io.hexagon.repository.ebean.EbeanCurdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Xuegui Yuan
 */
@Repository
public class EbeanUserRepository extends EbeanCurdRepository<User, Long> implements UserRepository {
    @Autowired
    private EbeanServer ebeanServer;

    @Override
    public EbeanServer getEbeanServer() {
        return ebeanServer;
    }

    @Override
    public Class getEntityClass() {
        return User.class;
    }
}
