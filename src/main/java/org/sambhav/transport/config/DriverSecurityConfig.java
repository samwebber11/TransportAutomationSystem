package org.sambhav.transport.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@Order(2)
@EnableWebSecurity
public class DriverSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/driver/**")
			.authorizeRequests()
			.anyRequest()
			.authenticated().and()
			.csrf().disable()
			.formLogin()
			.loginPage("/driver/login")
			.defaultSuccessUrl("/confirmation")
			.failureUrl("/driver/login?error=true")
			.usernameParameter("vehicleNo")
			.passwordParameter("password")
			.and()
			.logout()
    		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
    		.logoutSuccessUrl("/").and().exceptionHandling()
    		.accessDeniedPage("/access-denied");
			
	}
}
