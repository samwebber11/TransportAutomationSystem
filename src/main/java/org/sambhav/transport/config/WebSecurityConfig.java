//package org.sambhav.transport.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
////
////    @Autowired
////    private CustomSuccessHandler customSuccess;
//    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//  	
////    	http.sessionManagement().maximumSessions(1).sessionRegistry(sessionRegistry());
//    	
////    	http.antMatcher("/swagger-ui.html").permitAll();
//    	
//    	
//    	http.authorizeRequests()
//                .antMatchers("/resources/**", "/signup","/","/*").permitAll()
//                .antMatchers("/admin").permitAll()
//                .anyRequest().authenticated()
//                .and()
//            .formLogin()
//                .loginPage("/login").defaultSuccessUrl("/welcome")
//                .permitAll()
//                .and()
//            .logout()
//                .permitAll();
//    }
// 
//    @Override
//	public void configure(WebSecurity web) throws Exception {
//            
//    	System.out.println("Changed the security aspects");
//    	web.ignoring().antMatchers("/v2/api-docs",
//                                       "/configuration/ui",
//                                       "/swagger-resources",
//                                       "/configuration/security",
//                                       "/swagger-ui.html",
//                                       "/webjars/**");
//        }
//    
//    @Bean
//    public AuthenticationManager customAuthenticationManager() throws Exception {
//        return authenticationManager();
//    }
//   
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
//    }
//}