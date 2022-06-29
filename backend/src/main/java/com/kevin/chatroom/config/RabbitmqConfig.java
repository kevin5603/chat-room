package com.kevin.chatroom.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    final public static String EXCHANGENAME = "websocketExchange";

    @Bean
    FanoutExchange exchange() {
        return new FanoutExchange(EXCHANGENAME);
    }

    @Bean
    public Queue queue(){
        return new Queue(orderQueueName());
    }

    @Bean
    Binding bindingExchangeMessage(Queue queue, FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
    }

    @Bean
    public SimpleMessageListenerContainer messageListenerContainer(OrderReceiver orderReceiver, @Qualifier("rabbitConnectionFactory") CachingConnectionFactory cachingConnectionFactory){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(cachingConnectionFactory);
        // 監聽佇列的名稱
        container.setQueueNames(orderQueueName());
        container.setExposeListenerChannel(true);
        // 設定每個消費者獲取的最大訊息數量
        container.setPrefetchCount(100);
        // 消費者的個數
        container.setConcurrentConsumers(1);
        // 設定確認模式為自動確認
        container.setAcknowledgeMode(AcknowledgeMode.AUTO);
        container.setMessageListener(orderReceiver);
        return container;
    }


    /**
     * 在這裡寫獲取訂單佇列名的具體過程
     * @return
     */
    public String orderQueueName(){
        return "orderChannel";
    }

}
