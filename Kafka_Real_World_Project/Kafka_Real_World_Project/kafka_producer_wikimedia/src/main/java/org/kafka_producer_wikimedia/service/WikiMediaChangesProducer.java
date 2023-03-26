package org.kafka_producer_wikimedia.service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.kafka_producer_wikimedia.config.WikiMediaChangesHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

@Service
public class WikiMediaChangesProducer {
	
	private static final Logger LOGGER= LoggerFactory.getLogger(WikiMediaChangesProducer.class);
	
	private KafkaTemplate<String, String>kafkaTemplate;
	
	
	public WikiMediaChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}


	public void sendMessage() throws InterruptedException
	{
		LOGGER.info(String.format("Message sent ->%s", null));
		
		String topic= "wiki_media";
		
		EventHandler eventHandler=new WikiMediaChangesHandler(kafkaTemplate,topic);//handle the new events, it wilt trigger where there is change in event
		String url = "https://stream.wikimedia.org/v2/stream/recentchange";//connect to the wiki media source
        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));//
        EventSource eventSource = builder.build();//it read real time data and trigger respective handler
        eventSource.start();//WikiMediaChangesHandler send changes to the created topic

        TimeUnit.MINUTES.sleep(10);
//to read real time data we use event source
	}
	

}
