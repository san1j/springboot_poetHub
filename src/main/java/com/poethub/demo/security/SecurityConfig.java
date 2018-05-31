package com.poethub.demo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
 import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private CustomHandler customHandler;

	@Value("${spring.user.username}")
	private String username;
	@Value("${spring.user.password}")
	private String password;
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers("/userPage/**", "/newPoem", "/editPoem/{id}", "/deletePoem/{id}").authenticated()
				.anyRequest().permitAll().and().formLogin().loginPage("/login**").defaultSuccessUrl("/").permitAll().and()
				.logout().logoutSuccessUrl("/").permitAll();

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username, password,enabled from USER where username=?")
				.authoritiesByUsernameQuery("select username, role from USER where username=?")
				.passwordEncoder(passwordEncoder());

		auth.inMemoryAuthentication().withUser(username).password(password).roles("USER");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
