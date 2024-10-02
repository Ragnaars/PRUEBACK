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
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = "org.dgac.cl.model.dao", 
    entityManagerFactoryRef="anesaEntityManager", 
    transactionManagerRef="anesaTransactionManager"
)
public class AnesaDataSourceConfig {

    @Value("${spring.jpa.database-platform}")
    private String dialect;

    // Configuramos el DataSource usando las propiedades de `application.properties`
    @Bean("anesaDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.anesa")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    // Inyectamos el DataSource usando @Qualifier en vez de invocar directamente a `dataSource()`
    @Bean("anesaEntityManager")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
        @Qualifier("anesaDataSource") DataSource dataSource) {
        
        LocalContainerEntityManagerFactoryBean localContainer = new LocalContainerEntityManagerFactoryBean();
        localContainer.setDataSource(dataSource); // Usamos el DataSource inyectado
        localContainer.setPersistenceUnitName("anesa");
        localContainer.setPackagesToScan("org.dgac.cl.model.entity");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        localContainer.setJpaVendorAdapter(vendorAdapter);

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", dialect);
        localContainer.setJpaPropertyMap(properties);

        return localContainer;
    }

    @Bean("anesaTransactionManager")
    @Primary
    public PlatformTransactionManager platformTransactionManager(
        @Qualifier("anesaEntityManager") EntityManagerFactory entityManagerFactoryBean) {
        return new JpaTransactionManager(entityManagerFactoryBean);
    }
}
