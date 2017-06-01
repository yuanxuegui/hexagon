package io.hexagon.demo.config;

import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author Xuegui Yuan
 */
@Configuration
public class EbeanConfiguration {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Bean
    @Primary
    public ServerConfig defaultEbeanServerConfig() {
        ServerConfig config = new ServerConfig();

//        config.setDataSource(dataSource);
//        config.addPackage("io.hexagon.demo.domain.model");
//        config.setExternalTransactionManager(new SpringAwareJdbcTransactionManager());

        config.loadFromProperties();
        config.setName("db");
        config.setDefaultServer(true);
        config.setAutoCommitMode(false);
        config.setExpressionNativeIlike(true);

        return config;
    }

    @Bean
    @Primary
    public EbeanServer defaultEbeanServer(ServerConfig defaultEbeanServerConfig) {
        return EbeanServerFactory.create(defaultEbeanServerConfig);
    }


    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Bean
    @Qualifier("secondEbeanServerConfig")
    public ServerConfig secondEbeanServerConfig() {
        ServerConfig config = new ServerConfig();

//        config.setDataSource(dataSource);
//        config.addPackage("io.hexagon.demo.domain.model");
//        config.setExternalTransactionManager(new SpringAwareJdbcTransactionManager());

        config.loadFromProperties();
        config.setName("second");
        config.setDefaultServer(true);
        config.setAutoCommitMode(false);
        config.setExpressionNativeIlike(true);

        return config;
    }

    @Bean
    @Qualifier("secondEbeanServer")
    public EbeanServer secondEbeanServer(@Qualifier("secondEbeanServerConfig") ServerConfig ebeanServerConfig) {
        return EbeanServerFactory.create(ebeanServerConfig);
    }
}
