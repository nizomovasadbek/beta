package uz.beta.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static uz.beta.permission.ApplicationUserPermission.*;
import static uz.beta.permission.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
//                .antMatchers("/api/v1/students/*").hasAuthority(STUDENT_READ.getPermission())
//                .antMatchers(HttpMethod.POST, "/api/v1/students/add")
//                .hasAuthority(ADMIN_WRITE.getPermission())
                .anyRequest().authenticated()
                .and().formLogin()
                .successForwardUrl("/");
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails student = User.builder()
                .username("student")
                .authorities(STUDENT.getSimpleGrantedAuthority())
                .password(passwordEncoder.encode("student"))
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .authorities(ADMIN.getSimpleGrantedAuthority())
                .password(passwordEncoder.encode("admin"))
                .build();

        UserDetails teacher = User.builder()
                .username("teacher")
                .authorities(TEACHER.getSimpleGrantedAuthority())
                .password(passwordEncoder.encode("teacher"))
                .build();

        return new InMemoryUserDetailsManager(student, admin, teacher);
    }
}
