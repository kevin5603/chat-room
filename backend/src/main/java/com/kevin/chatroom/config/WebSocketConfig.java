package com.kevin.chatroom.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Value("${frontend.url}")
    private String frontendUrl;

    @Value("${spring.rabbitmq.stomp.host}")
    private String stompHost;

    @Value("${spring.rabbitmq.stomp.port}")
    private int stompPort;

    @Value("${spring.rabbitmq.stomp.user}")
    private String stompUser;

    @Value("${spring.rabbitmq.stomp.passcode}")
    private String stompPasscode;


    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry
                .enableStompBrokerRelay("/topic", "/user")
                .setRelayHost(stompHost)
                .setRelayPort(stompPort)
                .setClientLogin(stompUser)
                .setClientPasscode(stompPasscode);
    }

    // websocket handshake endpoint
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/my-websocket")
                .setAllowedOrigins(frontendUrl)
                .withSockJS();
    }

}
