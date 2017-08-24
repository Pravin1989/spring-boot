package com.springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{
	private static Logger logger = LoggerFactory
			.getLogger(SecurityConfig.class);

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		logger.info("Security configureGlobal executed");
		auth.inMemoryAuthentication().withUser("admin").password("password")
				.roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("Security configure executed");
		http.httpBasic().and().authorizeRequests().antMatchers("/")
				.hasRole("ADMIN").anyRequest().authenticated();
		http.sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
		 http.sessionManagement().maximumSessions(2).expiredUrl("/expiredSession.jsp");
		 http.sessionManagement().invalidSessionUrl("/invalidSession.jsp");
		 http.sessionManagement().sessionFixation().migrateSession();
	}		
}
