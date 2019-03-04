package com.poc.secureapp.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{

	//commenting for oauth2 implementation
//	@Autowired
//	private UserDetailsService userDetailsService;
//	
//	@Bean
//	public AuthenticationProvider authProvider()
//	{
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setUserDetailsService(userDetailsService);
//		provider.setPasswordEncoder(new BCryptPasswordEncoder());
//		return provider;
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable()
	.authorizeRequests().antMatchers("/login").permitAll().anyRequest().authenticated();
//	.and().httpBasic();
	
	//commenting for oauth 2 implementation
//	.formLogin().loginPage("/login").permitAll()
//	.and()
//	.logout().invalidateHttpSession(true)
//	.clearAuthentication(true)
//	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//	.logoutSuccessUrl("/logout-success").permitAll();
	}
	
	
	
	//Commented for the more upgradation for fetching credentials from Database
	/*
	 * 
	 * @Bean
	 * 
	 * @Override protected UserDetailsService userDetailsService() {
	 * List<UserDetails> users = new ArrayList<>();
	 * users.add(User.withDefaultPasswordEncoder().username("rohit").password(
	 * "jaimatadi").roles("USER").build()); return new
	 * InMemoryUserDetailsManager(users); }
	 */

	
}
