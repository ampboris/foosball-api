package com.wpc.foosball.foosball.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.wpc.foosball.foosball.repository.FoosbalResultRepository;

@Configuration
@EnableWebSecurity
@EnableMongoRepositories(basePackageClasses = FoosbalResultRepository.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()

                .withUser("test").password("test").roles("USER").and()
                .withUser("demo").password("test").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
    	httpSecurity
        // we don't need CSRF because our token is invulnerable
        .csrf().disable()
        // don't create session
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .authorizeRequests()
        .anyRequest().permitAll();

//        httpSecurity
//                .authorizeRequests()
//                .anyRequest()
//                .fullyAuthenticated()
//                //.antMatchers("**/rest/*")
//                .and()
//                //.addFilterBefore(customFilter(), BasicAuthenticationFilter.class)
//                .httpBasic();
//        httpSecurity.csrf().disable();

    }

    @Bean
    public CustomFilter customFilter() {
        return new CustomFilter();
    }
}
