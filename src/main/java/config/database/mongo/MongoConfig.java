package config.database.mongo;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

@Configuration
public class MongoConfig {

	private static final String DATABASE_NAME = "stock";

	private Logger log = LoggerFactory.getLogger(getClass());

	public @Bean MongoClient mongoClient() {
		log.warn("*** Connecting to MongoDB, collection: {} ***", DATABASE_NAME);
		return new MongoClient(Arrays.asList(new ServerAddress("localhost", 27017)),
				MongoClientOptions.builder().readPreference(ReadPreference.primaryPreferred()).connectionsPerHost(30)
						.writeConcern(WriteConcern.ACKNOWLEDGED).build());
	}
}
