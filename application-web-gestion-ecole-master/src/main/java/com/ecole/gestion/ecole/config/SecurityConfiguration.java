//package com.ecole.gestion.ecole.config;
// 
////
////
////
//import javax.sql.DataSource;
////
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// 
//////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
////
//@Configuration
//@EnableWebSecurity
////@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
// 
//	
//	@Autowired
//	CustomSuccessHandler customSuccessHandler;
//	
//	@Autowired
//	private DataSource dataSource;
////	
//	@Value("${spring.queries.users-query}")
//	private String usersQuery;
//	
//	@Value("${spring.queries.roles-query}")
//	private String rolesQuery;
//	
//	@Autowired
//	public void globalconfig(AuthenticationManagerBuilder auth) throws Exception {
//
//		auth.
//		jdbcAuthentication()
//		.usersByUsernameQuery(usersQuery)
//		.authoritiesByUsernameQuery(rolesQuery)
//		.dataSource(dataSource);}
//	
//	@Override
//	public void configure(HttpSecurity http) throws Exception{
//		http.
//		authorizeRequests()
//		.anyRequest().authenticated()
////		.antMatchers("/login").permitAll()
//		.and().formLogin().loginPage("/login").permitAll()
//		.successHandler(customSuccessHandler)
//		.usernameParameter("login")
//        .passwordParameter("password");
////		
//		 
//	
//		
//	}
//	 
//	
//	
//	
//	 
//	
////
//}