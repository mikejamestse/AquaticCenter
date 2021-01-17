package com.uqam.inf5190.natation.security.config;


import com.uqam.inf5190.natation.security.MyAuthenticationFailureHandler;
import com.uqam.inf5190.natation.security.MyAuthenticationSuccessHandler;
import com.uqam.inf5190.natation.security.MyLogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(final HttpSecurity httpSecurity) throws Exception {
        httpSecurity.
                // protection contre les attaques cross site request forgery
                csrf().disable()

                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/").permitAll()
                .antMatchers("/cours/afficherCours").permitAll()
                .antMatchers("/login*").permitAll()
                .antMatchers("/signup*").permitAll()
                .antMatchers("/signup/**").permitAll()
                .antMatchers("/h2-admin/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/images/**").permitAll()

                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .successHandler(mySuccessHandler())
                    .failureUrl("/login?authenticated=false")
                    .failureHandler(authenticationFailureHandler())
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessHandler(logoutSuccessHandler())
                .and()
                .headers().frameOptions().disable();
    }

    // On utilise pas de cryptage de mot de passe pour le moment
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public MyAuthenticationFailureHandler authenticationFailureHandler(){
        return new MyAuthenticationFailureHandler();
    }

    @Bean
    public MyLogoutSuccessHandler logoutSuccessHandler(){
        return new MyLogoutSuccessHandler();
    }

    @Bean
    public MyAuthenticationSuccessHandler mySuccessHandler(){
        return new MyAuthenticationSuccessHandler();
    }
}






