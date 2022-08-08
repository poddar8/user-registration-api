package com.example;

import com.example.restservice.RestServiceApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RestServiceApplication.class)
public class RestServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

}