package com.assignment.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.assignment"})
@EnableJpaRepositories("com.assignment")
public class WebMvcConfig implements WebMvcConfigurer{

	
	@Bean
	public InternalResourceViewResolver resolver(){		
		
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/pages/");
		resolver.setSuffix(".jsp");;
		return resolver;
	}
	
	@Bean
	public LocalValidatorFactoryBean localValidatorFactorybean(){
		
		return new LocalValidatorFactoryBean();	
	
	}

	@Override
	public Validator getValidator() {
	
		return localValidatorFactorybean();
	}
	
/*	@Bean
	public EntityManagerFactory entityManagerFactory(){
		String PERSISTENCE_UNIT_NAME="PERSISTENCE"; //same as we given in xml
		EntityManagerFactory factory;
		factory=Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		return factory;
		
	}
	
	
	@Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());
        return transactionManager;
    }*/
	
	
}
