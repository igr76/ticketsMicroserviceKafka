package com.example.stmlabs;

import com.example.stmlabs.jwt.JwtFilter;
import com.example.stmlabs.security.Encoder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import static org.springframework.security.config.Customizer.withDefaults;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

  private  JwtFilter jwtFilter;
//  private   UserDetailsService userDetailService;
//
//  public WebSecurityConfig(JwtFilter jwtFilter, UserDetailsService userDetailService) {
//    this.jwtFilter = jwtFilter;
//    this.userDetailService = userDetailService;
//  }

  private static final String[] AUTH_WHITELIST = {
      "/swagger-resources/**",
      "/swagger-ui.html",
      "/v3/api-docs",
      "/webjars/**",
      "/login",
      "/ticket/*"
  };



//  @Bean
//  protected DaoAuthenticationProvider daoAuthenticationProvider() {
//    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//    daoAuthenticationProvider.setPasswordEncoder(Encoder.passwordEncoderWithBCrypt());
//    daoAuthenticationProvider.setUserDetailsService(userDetailService);
//    return daoAuthenticationProvider;
//  }


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

