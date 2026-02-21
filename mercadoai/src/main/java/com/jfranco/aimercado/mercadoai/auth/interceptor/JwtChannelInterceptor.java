package com.jfranco.aimercado.mercadoai.auth.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import com.jfranco.aimercado.mercadoai.auth.JwtTokenProvider;

@Component
public class JwtChannelInterceptor implements ChannelInterceptor {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
public Message<?> preSend(Message<?> message, MessageChannel channel) {
    StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
    
    System.out.println("=== INTERCEPTOR ===");
    System.out.println("Command: " + accessor.getCommand());
    System.out.println("User before: " + accessor.getUser());
    
    if (StompCommand.CONNECT.equals(accessor.getCommand())) {
        String token = accessor.getFirstNativeHeader("Authorization");
        System.out.println("Token: " + token);
        
        if (token != null && token.startsWith("Bearer ")) {
            String jwt = token.substring(7);
            if (jwtTokenProvider.validateToken(jwt)) {
                String username = jwtTokenProvider.getUsername(jwt);
                System.out.println("Username from token: " + username);
                
                UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(username, null, jwtTokenProvider.getAuthorities(jwt));
                accessor.setUser(authentication);
                
                if (accessor.getSessionAttributes() != null) {
                    accessor.getSessionAttributes().put("AUTHENTICATION", authentication);
                }
                
                System.out.println("User set: " + accessor.getUser());
            }
        }
    } else {
        if (accessor.getSessionAttributes() != null) {
            UsernamePasswordAuthenticationToken auth = 
                (UsernamePasswordAuthenticationToken) accessor.getSessionAttributes().get("AUTHENTICATION");
            if (auth != null) {
                accessor.setUser(auth);
            }
        }
    }
    
    System.out.println("User after: " + accessor.getUser());
    System.out.println("===================");
    
    // IMPORTANT: Return the modified message with the updated accessor
    return MessageBuilder.createMessage(message.getPayload(), accessor.getMessageHeaders());
}
}
