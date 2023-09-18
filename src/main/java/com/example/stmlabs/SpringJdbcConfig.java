package com.example.stmlabs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.baeldung.jdbc")
public class SpringJdbcConfig {
    @Bean
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.postgresql.jdbc.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/stm-labs");
        dataSource.setUsername("igr");
        dataSource.setPassword("111111");

        return dataSource;
    }
}
