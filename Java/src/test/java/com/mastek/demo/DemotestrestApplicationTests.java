package com.mastek.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mastek.demo.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DemotestrestApplicationTests {

	@Autowired(required=true)
	TestRestTemplate testRestTemplate;

	@Test
	public void defaultPage() throws IOException {
		String message=testRestTemplate.getForObject("/", String.class);
		assertThat(new ObjectMapper().readTree(message).get("user_name").textValue())
		.isEqualTo("User1");
		
		assertThat(new ObjectMapper().readTree(message).get("password").textValue())
		.isEqualTo("*****");
		
	}
	
}
