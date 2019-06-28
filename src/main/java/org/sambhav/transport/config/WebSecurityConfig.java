package org.sambhav.transport.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@Order(1)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String usersQuery;
//
//    @Value("${spring.queries.roles-query}")
//    private String rolesQuery;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

    	
    	http.authorizeRequests()
    		.antMatchers("/").permitAll()
    		.antMatchers("/registration").permitAll()
    		.antMatchers("/login").permitAll()
    		.antMatchers("/homepage").permitAll()
    		.antMatchers("/driver/**").permitAll()
    		.antMatchers("/admin/**").hasAuthority("ADMIN")
    		.anyRequest()
    		.authenticated().and().csrf().disable().formLogin()
    		.loginPage("/login").failureUrl("/login?error=true")
    		.defaultSuccessUrl("/booking")
    		.usernameParameter("userName")
    		.passwordParameter("passwd")
    		.and()
    		.logout()
    		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
    		.logoutSuccessUrl("/").and().exceptionHandling()
    		.accessDeniedPage("/access-denied");
    	
    }

    
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().
//    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

}
