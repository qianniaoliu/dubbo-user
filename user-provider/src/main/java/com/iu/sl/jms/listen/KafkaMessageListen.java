package com.iu.sl.jms.listen;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description:
 * @Author: ShenLong
 * @CreateDate: 2018/6/4 19:04
 */
@Component
public class KafkaMessageListen {

    private final static Logger logger = LoggerFactory.getLogger(KafkaMessageListen.class);


    @KafkaListener(topics = "mailTopic", containerFactory = "kafkaListenerContainerFactory")
    public void processMessage(List<ConsumerRecord<String,String>> records, Acknowledgment ack){
        try{
            logger.info("Message一批次的数量"+String.valueOf(records.size()));
            ack.acknowledge();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
