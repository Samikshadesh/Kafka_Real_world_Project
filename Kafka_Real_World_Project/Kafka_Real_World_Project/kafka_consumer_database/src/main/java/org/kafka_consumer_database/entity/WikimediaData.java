package org.kafka_consumer_database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class WikimediaData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Lob
	private String wikimediaData;
	//PRIVATE STRING NAME
	//My name is
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWikimediaData() {
		return wikimediaData;
	}

	public void setWikimediaData(String wikimediaData) {
		this.wikimediaData = wikimediaData;
	}
	

}
