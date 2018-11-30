package com.asa;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MqApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(MqApplicationTests.class);

	/**使用RocketMq的生产者*/
	@Autowired
	private DefaultMQProducer defaultMQProducer;

//	@Autowired
//	private DefaultMQPullConsumer defaultMQPullConsumer;

    private String topic = "sa_order";

    private String tag = "del";

	@Test
	public void send() throws MQClientException, RemotingException, MQBrokerException, InterruptedException{
		String msg = "demo1231231";
		logger.info("开始发送消息："+msg);
		Message sendMsg = new Message(topic, tag, msg.getBytes());
        // 延迟发送
		//        sendMsg.setDelayTimeLevel(3);
		//默认3秒超时
		SendResult sendResult = defaultMQProducer.send(sendMsg);
		logger.info("消息发送响应信息："+sendResult.toString());

//		Thread.sleep(3000);
//
//        Set<MessageQueue> messageQueueSet = defaultMQPullConsumer.fetchSubscribeMessageQueues("demo");
//
//        System.out.println(messageQueueSet);

//		Thread.sleep(10000);
	}

//	@Test
//	public void receive() throws MQClientException {
//		defaultMQPullConsumer.fetchSubscribeMessageQueues("DemoTopic");
//	}

}
