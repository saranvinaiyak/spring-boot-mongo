package com.example.mongodemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.Mapping;

@EnableMongoRepositories(basePackages = {"com.example.mongodemo.core.repository"})
@Configuration
public class MongoDbConfiguration {

    //The following beans have been added to override spring's default MappingMongoConverter, to prevent spring from adding _class field
    //to the documents.

    public @Bean MongoDatabaseFactory mongoDatabaseFactory()
    {
        return new SimpleMongoClientDatabaseFactory("mongodb://localhost:27017/students");
    }

    public @Bean MongoTemplate mongoTemplate()
    {
        MappingMongoConverter mongoConverter = new MappingMongoConverter(new DefaultDbRefResolver(mongoDatabaseFactory()), new MongoMappingContext());
        mongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return new MongoTemplate(mongoDatabaseFactory(), mongoConverter);
    }
}
