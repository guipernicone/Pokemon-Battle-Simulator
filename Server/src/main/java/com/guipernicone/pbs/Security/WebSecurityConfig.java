package com.guipernicone.pbs.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.guipernicone.pbs.Security.Service.AuthenticationService;
import com.guipernicone.pbs.Security.Service.TokenService;
import com.guipernicone.pbs.User.UserRepository;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Authorize configure
	 */
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
		
			// Disable csrf (cross site request forgery)
			.csrf().disable()
			
			// Entry Points authorize
			.authorizeRequests()
			.antMatchers("/test").permitAll()
			.antMatchers("/auth/**").permitAll()
			.anyRequest().authenticated()
			
			.and()
			
			// Disable the creation of sessions
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		
			.and()
			
			// Add a filter to validate a token given on the header
			.addFilterBefore(new AuthenticationByTokenFilter(tokenService, userRepository), UsernamePasswordAuthenticationFilter.class);
			
			
	}
	
	/**
	 * Authentication configure
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authenticationService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	/**
	 * Statics resources  configure
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
