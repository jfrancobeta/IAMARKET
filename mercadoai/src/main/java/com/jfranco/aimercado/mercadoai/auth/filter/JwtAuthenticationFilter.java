package com.jfranco.aimercado.mercadoai.auth.filter;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfranco.aimercado.mercadoai.model.Usuario;
import com.jfranco.aimercado.mercadoai.repository.UsuarioRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static com.jfranco.aimercado.mercadoai.auth.TokenJwtConfig.SECRET_KEY;
import static com.jfranco.aimercado.mercadoai.auth.TokenJwtConfig.HEADER_AUTHORIZATION;
import static com.jfranco.aimercado.mercadoai.auth.TokenJwtConfig.PREFIX_TOKEN;
import static com.jfranco.aimercado.mercadoai.auth.TokenJwtConfig.CONTENT_TYPE;;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{


    private AuthenticationManager authenticationManager;

    private UsuarioRepository usuarioRepository;

    public JwtAuthenticationFilter(
        AuthenticationManager authenticationManager,
        UsuarioRepository usuarioRepository) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
                String username = null;
                String password = null;

                try{
                    Usuario usuario = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
                    username = usuario.getUsername();
                    password = usuario.getPassword();
                }catch(IOException e){
                    e.printStackTrace();
                }

                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
                return this.authenticationManager.authenticate(authenticationToken);
            
        
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
                User user = (User) authResult.getPrincipal();

                String username = user.getUsername();

                Usuario usuario = usuarioRepository.findByUsername(username).get();

                Collection<? extends GrantedAuthority> roles = authResult.getAuthorities();

                boolean isAdmin = roles.stream()
                        .anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"));
                Claims claims = Jwts
                .claims()
                .add("authorities",new ObjectMapper().writeValueAsString(roles))
                .add("username", username)
                .add("isAdmin",isAdmin)
                .add("usuario", usuario.getId())
                .build();

                String jwt = Jwts.builder()
                .subject(username)
                .claims(claims)
                .signWith(SECRET_KEY)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 3600000))
                .compact();

                response.addHeader(HEADER_AUTHORIZATION, PREFIX_TOKEN + jwt);

                Map<String,String> body = new HashMap<>();
                body.put("token",jwt);
                body.put("username",username);
                body.put("message", "session: " +username);

                response.getWriter().write(new ObjectMapper().writeValueAsString(body));
                response.setContentType(CONTENT_TYPE);
                response.setStatus(200);
        
        
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException failed) throws IOException, ServletException {
                Map<String,String> body = new HashMap<>();
                body.put("message","error en la autenticacion con username y password incorrecto");
                body.put("errror", failed.getMessage());

                response.getWriter().write(new ObjectMapper().writeValueAsString(body));
                response.setContentType(CONTENT_TYPE);
                response.setStatus(401);
        
    }
    

    
    
}
