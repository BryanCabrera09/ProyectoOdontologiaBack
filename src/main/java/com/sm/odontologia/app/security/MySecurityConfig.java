//package com.sm.odontologia.app.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.sm.odontologia.app.service.UserDetailsServiceImpl;
//
//@EnableWebSecurity
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class MySecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private JwtAuthenticationEntryPoint unauthorizedHandler;
//
//	@Autowired
//	private UserDetailsServiceImpl userDetailsServiceImpl;
//
//	@Autowired
//	private JwtAuthenticationFilter jwtAuthenticationFilter;
//
//	@Override
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
//	}
//
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		/*http.csrf().disable().cors().disable().authorizeRequests()
//				.antMatchers("/generate-token", "/usuarios/", "/swagger-ui/**", "/webjars/**",
//						"/swagger-resources/**", "/v2/*", "/csrf", "*//*api/*")
//				.permitAll().antMatchers(HttpMethod.OPTIONS).permitAll().anyRequest().authenticated().and()
//				.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and().sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);*/
//		web.ignoring().antMatchers("/generate-token", "/usuarios/", "/swagger-ui/**", " /v3/api-docs/**");
//	}
//
//}
