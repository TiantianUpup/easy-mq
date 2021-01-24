package com.h2t.study;

import com.h2t.study.consumer.MqConsumer;
import com.h2t.study.dto.Message;
import com.h2t.study.producer.MqProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {

	@Test
	public void testMq() {
		MqProducer mqProducer = MqProducer.builder().build();
		MqConsumer mqConsumer = MqConsumer.builder().build();
		Message message1 = Message.builder()
			.key("test")
			.msg("hello easy mq1")
			.build();
		Message message2 = Message.builder()
			.key("test")
			.msg("hello easy mq2")
			.build();
		mqProducer.send(message1);
		mqProducer.send(message2);
		System.out.println(mqConsumer.consume(Message.builder().key("test1").build()));
	}

}
