package com.sandeep.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class TestController {

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@Autowired
	private TestRepository testRepository;

	@GetMapping
	public Object testMethod() {

		logger.debug("Test Controller in test project2 called");

		try {
			TestEntity testEntity = testRepository.findByName("testData");

			if (testEntity == null) {
				throw new RuntimeException("No data found in the database");
			}

			return new ResponseEntity<>(testEntity.getData(), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}