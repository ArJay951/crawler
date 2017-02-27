package sample.arjay.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import sample.arjay.pojo.Daily;

@Repository
public interface DailyRepository extends MongoRepository<Daily, String> {
	
}
