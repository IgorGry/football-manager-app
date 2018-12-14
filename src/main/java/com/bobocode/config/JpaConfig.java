package com.bobocode.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;


@Configuration
public class JpaConfig {
//    @Bean
//    public DataSource dataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("org.postgresql.Driver");
//        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/bobocode_db");
//        dataSourceBuilder.username("bobouser");
//        dataSourceBuilder.password("bobopass");
//        return dataSourceBuilder.build();
//    }
//
//    @Bean
//    public JpaVendorAdapter jpaVendorAdapter() {
//        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//        adapter.setDatabase(Database.H2);
//        adapter.setShowSql(true);
//        adapter.setGenerateDdl(true); // this sets hibernate.hbm2ddl.auto=update (Hibernate will generate db tables)
//        return adapter;
//    }

//    @Bean(name = "entityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean localContainerEMF(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
//        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
//        emf.setDataSource(dataSource);
//        emf.setJpaVendorAdapter(jpaVendorAdapter);
//        emf.setPackagesToScan("com.bobocode.model");
//        return emf;
//    }

    // todo: instead of configuring previous three beans you can use file META-INF/persistence.xml and the following bean
    @Bean("entityManagerFactory")
    public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
        emfb.setPersistenceUnitName("BasicEntitiesPostgres");
        return emfb;
    }
}