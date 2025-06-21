package com.example.flightbooking.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
public class DataSourceConfig {

    private final DataSourceProperties props;

    public DataSourceConfig(DataSourceProperties props) {
        this.props = props;
    }

    /**
     * Registers a DataSource built from the spring.datasource.* properties
     * in application.yml (url, driver, etc.).
     */
    @Bean
    public DataSource sqliteDataSource() {
        return props.initializeDataSourceBuilder().build();
    }
}
