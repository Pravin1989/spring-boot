package com.springmvc.controller;

//import javax.sql.DataSource;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = "com.springmvc.models")
@ComponentScan(basePackages = "com.springmvc.services")
@ComponentScan(basePackages = "com.springmvc.repository")
@EnableWebMvc
public class SpringConfig extends WebMvcConfigurerAdapter {
	private static Logger logger = LoggerFactory.getLogger(SpringConfig.class);
	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
			"classpath:/WEB-INF/classes/static/"};

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setViewClass(JstlView.class);
		vr.setPrefix("/WEB-INF/views/");
		vr.setSuffix(".jsp");
		logger.info("Ïnternal View Resolver is executed");
		return vr;
	}

	/*
	 * @Bean public DataSource dataSource() { DataSourceBuilder builder =
	 * DataSourceBuilder.create();
	 * builder.url("jdbc:postgresql://localhost:5432/springmvc");
	 * builder.username("postgres"); builder.password("root");
	 * logger.info("Data Source is initialized"); builder. return
	 * builder.build(); }
	 */
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		logger.info("Resources is initialized");
	    registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/classes/static/");
	}
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
        logger.info("configureDefaultServletHandling is initialized");
    }	
		 

	@Bean
	public DataSource dataSource() {
		logger.info("Data Source is initialized");
		PoolProperties pool = new PoolProperties();
		pool.setUrl("jdbc:postgresql://localhost:5432/springmvc");
		pool.setUsername("postgres");
		pool.setPassword("root");
		pool.setMaxActive(10);
		pool.setMaxAge(1000000);
		DataSource dataSource = new DataSource();
		dataSource.setPoolProperties(pool);
		return dataSource;
	}
	
	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
		logger.info("HttpSessionEventPublisher is initialized");
	    return new HttpSessionEventPublisher();
	}

	/*
	 * @Bean public TomcatEmbeddedServletContainerFactory tomcatFactory() {
	 * return new TomcatEmbeddedServletContainerFactory() {
	 * 
	 * @Override protected TomcatEmbeddedServletContainer
	 * getTomcatEmbeddedServletContainer( Tomcat tomcat) {
	 * tomcat.enableNaming();
	 * 
	 * return super.getTomcatEmbeddedServletContainer(tomcat); } }; }
	 */

}