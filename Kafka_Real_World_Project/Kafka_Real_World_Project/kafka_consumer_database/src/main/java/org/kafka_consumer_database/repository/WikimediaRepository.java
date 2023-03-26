package org.kafka_consumer_database.repository;

import org.kafka_consumer_database.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikimediaRepository extends JpaRepository<WikimediaData, Long> {

}
