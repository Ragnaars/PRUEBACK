package org.dgac.cl.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration //inyecta beans al contener de dependencias de spring
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = "org.dgac.cl.modelSiscred.dao", 
    entityManagerFactoryRef="siscredEntityManager", 
    transactionManagerRef="siscredTransactionManager"
    )
public class SiscredDataSourceConfig {
    @Value("${spring.jpa.database-platform}")
    private String dialect;

@Bean("siscredDataSource")
@ConfigurationProperties(prefix = "spring.datasource.siscred")
public DataSource dataSource(){
    return DataSourceBuilder.create().build();
}

@Bean("siscredEntityManager")
public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(@Qualifier("siscredDataSource") DataSource dataSource){
    LocalContainerEntityManagerFactoryBean localContainer = 
        new LocalContainerEntityManagerFactoryBean();
    localContainer.setDataSource(dataSource());
    localContainer.setPersistenceUnitName("siscred");
    localContainer.setPackagesToScan("org.dgac.cl.modelSiscred.entity");

    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    localContainer.setJpaVendorAdapter(vendorAdapter);

    Map<String,Object> properties = new HashMap<>();
    properties.put("hibernate.dialect", dialect);
    localContainer.setJpaPropertyMap(properties);


    return localContainer;
}

@Bean("siscredTransactionManager")
public PlatformTransactionManager platformTransactionManager(
    @Qualifier("siscredEntityManager") EntityManagerFactory entityManagerFactoryBean){
    return new JpaTransactionManager(entityManagerFactoryBean);
}


}