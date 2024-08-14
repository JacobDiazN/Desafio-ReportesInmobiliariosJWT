package cl.praxis.ReportesInmobiliarios.configure;

import cl.praxis.ReportesInmobiliarios.model.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    private final UserDetailsService userDetailsService;
    private final JwtFilterRequest jwtFilterRequest;

    public SecurityConfig(UserDetailsService userDetailsService, JwtFilterRequest jwtFilterRequest) {
        this.userDetailsService = userDetailsService;
        this.jwtFilterRequest = jwtFilterRequest;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)  throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsServiceImpl userDetailService){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailService);
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/auth").permitAll()
                        // Permisos para el rol USER
                        .requestMatchers(HttpMethod.GET, "/api/propiedades", "/api/propiedades/{id}").hasAnyRole("ADMIN", "USER")
                        // Permisos para el rol ADMIN
                        .requestMatchers(HttpMethod.POST, "/api/propiedades").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/propiedades").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/propiedades/{id}").hasRole("ADMIN")
                        .anyRequest().authenticated())
                        .httpBasic(withDefaults());

        http.addFilterBefore(jwtFilterRequest, UsernamePasswordAuthenticationFilter.class);

        return http.build();

    }
}


