package com.iu.sl.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.AbstractMessageListenerContainer;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.policy.ExceptionClassifierRetryPolicy;
import org.springframework.retry.policy.TimeoutRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: ShenLong
 * @CreateDate: 2018/6/5 18:05
 */
@Configuration
@EnableKafka
public class KafkaConsumerConfig {


    @Value("${athena.kafka.consumer.bootstrap-servers}")
    public String servers;

    @Value("${athena.kafka.consumer.group-id}")
    public String groupId;

    @Value("${athena.kafka.consumer.auto-offset-reset}")
    public String autoOffsetReset;

    @Value("${athena.kafka.consumer.enable-auto-commit}")
    public String enableAutoCommit;

    @Value("${athena.kafka.consumer.fetch-min-size}")
    public String fetchMinSize;

    @Value("${athena.kafka.consumer.client-id}")
    public String clientId;


    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Integer,String>>
    kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<Integer,String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(3);
        factory.getContainerProperties().setPollTimeout(3000);
        factory.getContainerProperties().setIdleEventInterval(60000L);
        factory.getContainerProperties().setAckMode(AbstractMessageListenerContainer.AckMode.MANUAL_IMMEDIATE);
        /*factory.setBatchListener(true);*/
        factory.setStatefulRetry(true);
        factory.setRetryTemplate(retryTemplate());
        return factory;
    }

    @Bean
    public ConsumerFactory<Integer,String> consumerFactory(){
        return new DefaultKafkaConsumerFactory<>(consumersConfigs());
    }

    @Bean
    public Map<String,Object> consumersConfigs(){
        Map<String,Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,servers);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,enableAutoCommit);
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG,300000);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,autoOffsetReset);
        props.put(ConsumerConfig.GROUP_ID_CONFIG,groupId);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG,5);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
        return props;
    }

    @Bean
    public RetryTemplate retryTemplate(){
        RetryTemplate template = new RetryTemplate();
        /*TimeoutRetryPolicy policy = new TimeoutRetryPolicy();
        policy.setTimeout(30000L);*/
        ExceptionClassifierRetryPolicy policy = new ExceptionClassifierRetryPolicy();
        template.setRetryPolicy(policy);
        return template;
    }
}
