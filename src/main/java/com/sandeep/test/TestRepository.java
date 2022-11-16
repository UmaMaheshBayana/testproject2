package com.sandeep.test;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepository extends MongoRepository<TestEntity, String> {

	TestEntity findByName(String string);

}
