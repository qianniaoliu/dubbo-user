package com.iu.sl.jms.listen;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @Description:
 * @Author: WangLiHong
 * @CreateDate: 2018/4/12 11:41
 **/
public class JmsMessageListen implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("收到消息:---------------" );
    }
}
