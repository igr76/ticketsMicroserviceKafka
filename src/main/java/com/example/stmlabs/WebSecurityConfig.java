package com.example.stmlabs;

import com.example.stmlabs.jwt.JwtFilter;
import com.example.stmlabs.security.Encoder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

  private final JwtFilter jwtFilter;


  private static final String[] AUTH_WHITELIST = {
      "/swagger-resources/**",
      "/swagger-ui.html",
      "/v3/api-docs",
      "/webjars/**",
      "/login",
      "/ticket/*"
  };
  private final UserDetailsService userDetailService;

  @Bean
  protected DaoAuthenticationProvider daoAuthenticationProvider() {
    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setPasswordEncoder(Encoder.passwordEncoderWithBCrypt());
    daoAuthenticationProvider.setUserDetailsService(userDetailService);
    return daoAuthenticationProvider;
  }

  @Bean
  protected AuthenticationManagerBuilder authenticationManagerBuilder(
      AuthenticationManagerBuilder auth
  ) {
    return auth.authenticationProvider(daoAuthenticationProvider());
  }


  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests((authz) ->
        {
          try {
            authz
                    .requestMatchers(AUTH_WHITELIST).permitAll()
                .requestMatchers(HttpMethod.GET, "/ticket").permitAll()
                .requestMatchers( "/users/**")
                    .authenticated();
          } catch (Exception e) {
            throw new RuntimeException(e);
          }
        })
            .addFilterAfter(jwtFilter, UsernamePasswordAuthenticationFilter.class)
        .cors(withDefaults())
        .httpBasic(withDefaults());
    return http.build();
  }


}

