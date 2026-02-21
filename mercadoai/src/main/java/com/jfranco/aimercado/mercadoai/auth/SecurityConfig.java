package com.jfranco.aimercado.mercadoai.auth;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.jfranco.aimercado.mercadoai.auth.filter.JwtAuthenticationFilter;
import com.jfranco.aimercado.mercadoai.auth.filter.JwtValidationFilter;
import com.jfranco.aimercado.mercadoai.repository.Usuario.UsuarioRepository;

@Configuration
public class SecurityConfig {

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenJwtConfig tokenJwtConfig;


    @Bean
    AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder() ;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http.authorizeHttpRequests(auth ->
        auth
        .requestMatchers("/ws-chat/**").permitAll()
        .requestMatchers(HttpMethod.POST, "/payments/webhook").permitAll()
        .requestMatchers(HttpMethod.POST, "/usuarios/create-user").permitAll() 
        .requestMatchers(HttpMethod.POST, "/usuarios/send-reset-code").permitAll() 
        .requestMatchers(HttpMethod.POST, "/usuarios/verify-reset-code").permitAll() 
        .requestMatchers(HttpMethod.POST, "/usuarios/reset-password").permitAll() 
        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html").permitAll()
        .requestMatchers(HttpMethod.GET, "/paises/").permitAll()
        .requestMatchers(HttpMethod.GET, "/industrias/").permitAll()
        .requestMatchers(HttpMethod.GET, "/habilidades/").permitAll()
        .requestMatchers(HttpMethod.GET, "/necesidades/").hasAnyRole("DEVELOPER", "COMPANY", "ADMIN") 
        .requestMatchers(HttpMethod.GET, "/necesidades/{id}").hasAnyRole("DEVELOPER", "ADMIN", "COMPANY") 
        .requestMatchers(HttpMethod.POST, "/necesidades/").hasAnyRole("DEVELOPER", "ADMIN", "COMPANY") 
        .requestMatchers(HttpMethod.PUT, "/necesidades/").hasAnyRole("DEVELOPER", "ADMIN", "COMPANY") 
        //categorias
        .requestMatchers(HttpMethod.GET, "/categorias/").hasAnyRole("DEVELOPER", "ADMIN", "COMPANY") 
        //soluciones
        .requestMatchers(HttpMethod.GET, "/soluciones/").hasAnyRole("DEVELOPER", "ADMIN", "COMPANY")
        .requestMatchers(HttpMethod.GET, "/soluciones/{id}").hasAnyRole("DEVELOPER", "ADMIN", "COMPANY")
        .requestMatchers(HttpMethod.POST, "/soluciones/").hasAnyRole("DEVELOPER", "ADMIN", "COMPANY")
        .requestMatchers(HttpMethod.PUT, "/soluciones/{id}").hasAnyRole("DEVELOPER", "ADMIN", "COMPANY")
        .requestMatchers(HttpMethod.DELETE, "/soluciones/eliminar/{id}").hasAnyRole("DEVELOPER", "ADMIN", "COMPANY")
        //proyectos
        .requestMatchers(HttpMethod.POST, "/proyectos/").hasAnyRole("DEVELOPER", "ADMIN", "COMPANY")
        .requestMatchers(HttpMethod.PUT, "/proyectos/{id}").hasAnyRole("DEVELOPER", "ADMIN", "COMPANY")
        .requestMatchers(HttpMethod.GET, "/proyectos/").hasAnyRole("DEVELOPER", "ADMIN", "COMPANY")
        .requestMatchers(HttpMethod.GET, "/proyectos/{id}").hasAnyRole("DEVELOPER", "ADMIN", "COMPANY")
        //proyectos hitos
        .requestMatchers(HttpMethod.POST, "/proyectos/{proyectoId}/hitos").hasAnyRole("DEVELOPER", "ADMIN", "COMPANY")
        .requestMatchers(HttpMethod.PUT, "/proyectos/{proyectoId}/hitos/{hitoId}").hasAnyRole("DEVELOPER", "ADMIN", "COMPANY")
        //propuestas
        .requestMatchers(HttpMethod.GET, "/propuestas/sent").hasAnyRole("DEVELOPER", "ADMIN", "COMPANY")
        .requestMatchers(HttpMethod.GET, "/propuestas/received").hasAnyRole("DEVELOPER", "ADMIN", "COMPANY")
        .requestMatchers(HttpMethod.GET, "/propuestas/{id}").hasAnyRole("DEVELOPER", "ADMIN", "COMPANY")
        .requestMatchers(HttpMethod.POST, "/propuestas/").hasAnyRole("DEVELOPER", "ADMIN", "COMPANY")
        .requestMatchers(HttpMethod.PUT, "/propuestas/{id}").hasAnyRole("DEVELOPER", "ADMIN", "COMPANY")
        .requestMatchers(HttpMethod.DELETE, "/propuestas/{id}").hasAnyRole("DEVELOPER", "ADMIN", "COMPANY")
        //entregables 
        .requestMatchers(HttpMethod.POST, "/entregables/{id}/upload").hasAnyRole( "ADMIN", "DEVELOPER")
        .requestMatchers(HttpMethod.POST, "/entregables/{id}/aprobar").hasAnyRole( "COMPANY", "ADMIN")
        .anyRequest().authenticated())
        .cors(cors -> cors.configurationSource(configurationSource())) 
        .addFilter(new JwtValidationFilter(authenticationManager(), tokenJwtConfig))
        .addFilter(new JwtAuthenticationFilter(authenticationManager(), usuarioRepository, tokenJwtConfig))
        .csrf(cr -> cr.disable()) 
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) 
        .build(); 

    }

    @Bean
    CorsConfigurationSource configurationSource(){
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOriginPatterns(Arrays.asList("*")); // Permitir todos los orígenes
        config.setAllowedOrigins(Arrays.asList("http://localhost:4200", "https://iamarket.vercel.app"));
        config.setAllowedMethods(Arrays.asList("POST","GET","PUT","DELETE"));
        config.setAllowedHeaders(Arrays.asList("Authorization","Content-Type"));
        config.setExposedHeaders(Arrays.asList("Content-Disposition"));
        config.setAllowCredentials(true); // Permitir credenciales

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",config);
        return source;
    }

    //aplicar el cors global
    @Bean
    FilterRegistrationBean<CorsFilter> corsFilter(){
        FilterRegistrationBean<CorsFilter> corsBean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(this.configurationSource()));
        corsBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return corsBean;
    }
}
