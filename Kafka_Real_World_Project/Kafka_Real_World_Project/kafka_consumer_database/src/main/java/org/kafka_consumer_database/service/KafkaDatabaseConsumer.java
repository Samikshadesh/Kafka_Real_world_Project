package org.kafka_consumer_database.service;

import org.kafka_consumer_database.entity.WikimediaData;
import org.kafka_consumer_database.repository.WikimediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
	
	private WikimediaRepository wikimediaRepository;
	//Constructor based Autowiring
	public KafkaDatabaseConsumer(WikimediaRepository wikimediaRepository) {
		this.wikimediaRepository = wikimediaRepository;
	}


	@KafkaListener(topics="wiki_media", groupId="myGroup")
	public void consume(String eventMessage) 
	{
		LOGGER.info(String.format("enent message receiver ->%s", eventMessage));
		
		WikimediaData wikimediaData=new WikimediaData();
		wikimediaData.setWikimediaData(eventMessage);
		
		wikimediaRepository.save(wikimediaData);
		
	}

}
