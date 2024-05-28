package com.sp.weather.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
/*  @Autowired
  private AppProperties appProperties;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    http.csrf(AbstractHttpConfigurer::disable)
//            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
//            .authorizeRequests(authorizeRequests ->
//                    authorizeRequests.anyRequest().permitAll() // Allow all requests
//            )
//    ;

    http.csrf(AbstractHttpConfigurer::disable)
        .cors(cors -> cors.configurationSource(corsConfigurationSource()))
        .authorizeHttpRequests(auth ->
                auth.anyRequest().permitAll())
    ;
    return http.build();
  }*/

  /**
   * This is CORS configuration Source bean, it will only use for the development environment to allow cross origins such as
   * Angular development build could be different origin to be Entertained by server, it will load the Allowed origins
   * from the application.properties file
   *
   * @return {@link CorsConfigurationSource}
   */
  /*@Bean
  CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    if (appProperties.getAllowedOrigins() != null && !appProperties.getAllowedOrigins().isEmpty()) {
      configuration.setAllowedOrigins((appProperties.getAllowedOrigins()));
      configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD"));
      configuration.setAllowedHeaders(Arrays.asList("Access-Control-Allow-Headers", "Origin", "Accept", "X-Requested-With", "Content-Type", "api_key", "Access-Control-Request-Method", "Authorization", "Access-Control-Request-Headers", "Access-Control-Expose-Headers", "X-Enforce", "X-Lang"));
      configuration.setExposedHeaders(Arrays.asList("X-Get-Header"));
      configuration.setMaxAge(3600L);
    }
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }*/
}
