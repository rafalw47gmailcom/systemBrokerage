package pl.touroperators.touroperatorr2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailService(){

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin2")
                .password("admin2")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }

    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/admin/newOffer").hasRole("ADMIN")
                .antMatchers("/admin/add").hasRole("ADMIN")
                .antMatchers("/admin/reservation").hasRole("ADMIN")
/*
                .antMatchers("/edit/{id}").hasRole("ADMIN")
                .antMatchers("/delete/{id}").hasRole("ADMIN")
                .antMatchers("/details/{id}").hasRole("ADMIN")
 */
                .and()
                .formLogin().permitAll();

    }

}