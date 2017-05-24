package com.farsunset.cim.mq;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JMS消费者 消息题的内容定义 消息对象 接收消息对象后： 接收到的消息体*
 * <p>
 */

/*@Service*/
public class ConsumInvateMsgListener implements MessageListener{
    private static final Logger logger = LoggerFactory.getLogger(ConsumInvateMsgListener.class);

    public void onMessage(Message message)
    {
        System.out.println("------------------");
        try {
            if (message instanceof TextMessage) {
                message = (TextMessage) message;
                try {
                    String txt = ((TextMessage) message).getText();
                    logger.debug("receive mq msg : "+txt);
                } catch (JMSException e) {
                    throw new RuntimeException("JMSException", e);
                }
            } else if (message instanceof BytesMessage) 
            {
                System.out.println("收到byte消息==========");
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }       
     }
  }
