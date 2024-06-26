package com.example.baFirstProjectTeam02.config;

import com.example.baFirstProjectTeam02.repository.posts.PostRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = {"com.example.baFirstProjectTeam02.repository.users",
                "com.example.baFirstProjectTeam02.repository.roles",
                "com.example.baFirstProjectTeam02.repository.userPrincipal",
                "com.example.baFirstProjectTeam02.repository.posts",
                "com.example.baFirstProjectTeam02.repository.comment"},
        entityManagerFactoryRef = "entityMangerFactoryBean",
        transactionManagerRef = "tmJpa"
)
public class JpaConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityMangerFactoryBean(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.example.baFirstProjectTeam02.repository.users",
                "com.example.baFirstProjectTeam02.repository.roles",
                "com.example.baFirstProjectTeam02.repository.userPrincipal",
                "com.example.baFirstProjectTeam02.repository.posts",
                "com.example.baFirstProjectTeam02.repository.comment");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.use_sql_comment", "true");

        em.setJpaPropertyMap(properties);

        return em;
    }

    @Primary
    @Bean(name = "tmJpa")
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityMangerFactoryBean(dataSource).getObject());
        return transactionManager;
    }
}
