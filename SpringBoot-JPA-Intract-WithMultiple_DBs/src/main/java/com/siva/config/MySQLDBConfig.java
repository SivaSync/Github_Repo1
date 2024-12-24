package com.siva.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
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
@EnableJpaRepositories(basePackages = "com.siva.repo.to",
                        entityManagerFactoryRef = "mySqlEMF",
                        transactionManagerRef = "mysqlTxMgmr")
public class MySQLDBConfig 
{
	@Bean(name="mysqlDs")
    @ConfigurationProperties(prefix = "mysql.ds")
	@Primary
	public DataSource createMySQLDs()
	{
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="mySqlEMF")
	@Primary
	public LocalContainerEntityManagerFactoryBean createMySqlEMF(EntityManagerFactoryBuilder builder)
	{
	   // prepare JPA-hibernate properties
		Map<String,Object> map = new HashMap<>();
		map.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		map.put("hibernate.hbm2ddl.auto", "update");
		map.put("hibernate.show_sql", "true");
		
		/* create and return localContainerEntityManagerFactoryBean class 
		 using the EntityManagerFactoryBuilder Object  */
		return builder.dataSource(createMySQLDs()) // dataSource 
				.packages("com.siva.model.to") // model class packages //changed
				.properties(map) // SQL-hibernate properties 
				.build();
		
	}
	
	@Bean(name="mysqlTxMgmr")
	@Primary
     public JpaTransactionManager createMySQLTxMgmr(@Qualifier("mySqlEMF") EntityManagerFactory factory) {
    	 
      return new JpaTransactionManager(factory);
     }
	

}
