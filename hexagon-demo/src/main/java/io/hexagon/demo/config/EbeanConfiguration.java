package io.hexagon.demo.config;

import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author Xuegui Yuan
 */
@Configuration
public class EbeanConfiguration {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Bean
    public ServerConfig ebeanServerConfig() {
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
    public EbeanServer ebeanServer(ServerConfig serverConfig) {
        return EbeanServerFactory.create(serverConfig);
    }
}
