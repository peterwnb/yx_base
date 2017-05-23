package com.geek.yx.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.geek.yx.common.Constants.MQ_NAME;
import com.geek.yx.common.core.support.mq.QueueSender;

@ComponentScan
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:Spring-config.xml" })
public class MQTest {
	@Autowired
	private QueueSender queueSender;

	@Test
	public void test() {
		queueSender.send(MQ_NAME.INVITE_MSG, "test");
	}
}
