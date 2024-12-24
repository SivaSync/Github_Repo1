package com.siva.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.siva.repo.from",
                        entityManagerFactoryRef = "oracleEMF",
                        transactionManagerRef = "oracleTxMgmr")


public class OracleDBConfig 
{

	@Bean(name="oraDs")
	@ConfigurationProperties(prefix = "ora.ds")
	
	public DataSource createOraDs()
	{
		return DataSourceBuilder.create().build();
	}
	
	
	@Bean("oracleEMF")
	
	public LocalContainerEntityManagerFactoryBean createOraEMF(org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder builder)
	{
	   // prepare JPA-hibernate properties
		Map<String,Object> map = new HashMap<>();
		//map.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		map.put("hibernate.hbm2ddl.auto", "update");
		map.put("hibernate.show_sql", "true");
		
		/* create and return localContainerEntityManagerFactoryBean class 
		 using the EntityManagerFactoryBuilder Object  */
		
		return builder.dataSource(createOraDs()) // dataSource 
				.packages("com.siva.model.from") // model class packages
				.properties(map) // SQL-hibernate properties 
				.build();
		
	}
	
	@Bean(name="oracleTxMgmr")
	
     public JpaTransactionManager createOraclexMgmr(@Qualifier("oracleEMF") EntityManagerFactory factory) {
    	 
      return new JpaTransactionManager(factory);
     }
	
}
