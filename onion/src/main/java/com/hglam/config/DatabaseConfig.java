package com.hglam.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.hglam.repository")
@EnableTransactionManagement
public class DatabaseConfig {
    //config a bean of LocalContainerEntityManagerFactoryBean to manage EntityManagerFactory
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource){
        //create an object of LocalContainerEntityManagerFactoryBean
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        // create DataSource for EntityManagerFactoryBean
        entityManagerFactoryBean.setDataSource(dataSource);
        // create package to scan entities JPA
        entityManagerFactoryBean.setPackagesToScan("com.hglam.domain");
        return entityManagerFactoryBean;
    }
}
