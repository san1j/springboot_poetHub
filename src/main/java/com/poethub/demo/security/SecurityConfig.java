package com.poethub.demo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Value("${spring.user.username}")
	private String username;
	@Value("${spring.user.password}")
	private String password;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf()
        .disable()
		.authorizeRequests()
		.anyRequest().permitAll()
		.and()
        .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/")
            .permitAll()
            .and()
        .logout() 
            .logoutSuccessUrl("/")
            .permitAll();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
			auth
				.jdbcAuthentication()
				.dataSource(dataSource)
     			.usersByUsernameQuery("select username, password,enabled from USER where username=?");
				
			auth
			.inMemoryAuthentication()
			.withUser(username).password(password).roles("USER");
	}
}