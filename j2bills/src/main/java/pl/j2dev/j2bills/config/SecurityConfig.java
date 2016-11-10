package pl.j2dev.j2bills.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig {// extends WebSecurityConfigurerAdapter {
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		System.out.println("SECURITY CONFIG!");
//	    http
//	        .authorizeRequests()
//	            .anyRequest().authenticated() 
//	            .and()
//	        .formLogin()                      
//	            .and()
//	        .httpBasic();       
//		
//		// to jest zajebiste babciu!
//	}
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//		auth.
//			inMemoryAuthentication().withUser("j2bills").password("j2bills").roles("ADMIN");
//		
//	}
	
}
