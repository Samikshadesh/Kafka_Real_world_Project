package org.kafka_producer_wikimedia.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
public class WikiMediaChangesHandler implements EventHandler {
	
	//when their is new event EventHandler onMessage method will trigger....onMessage
	//will be called...onMessage method logic to sent message to the topic using kafkaTemplate
	
	private static final Logger LOGGER= LoggerFactory.getLogger(WikiMediaChangesHandler.class);
	
	private KafkaTemplate<String, String>kafkaTemplate;
	private String topic;
	

	public WikiMediaChangesHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
		this.kafkaTemplate = kafkaTemplate;
		this.topic = topic;
	}

	@Override
	public void onOpen() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClosed() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(String event, MessageEvent messageEvent) throws Exception {
		
		LOGGER.info(String.format("Event data ->%s", messageEvent.getData()));
		kafkaTemplate.send(topic, messageEvent.getData());
		
	}

	@Override
	public void onComment(String comment) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(Throwable t) {
		// TODO Auto-generated method stub
		
	}

}
