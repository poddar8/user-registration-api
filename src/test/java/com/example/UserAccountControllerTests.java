/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.restservice.RestServiceApplication;
import com.example.restservice.UserAccountController;
import com.example.restservice.UserAccountService;
import com.example.restservice.model.GeoLocationData;
import com.example.restservice.model.UserData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.junit.Test;
//import org.junit.runner.RunWith;


@ExtendWith(SpringExtension.class)
@WebMvcTest(value = RestServiceApplication.class)
//@SpringBootTest(classes = UserAccountControllerTests.class)
public class UserAccountControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserAccountService userAccountService;

	UserData userData = new UserData("Michele","TestPwd1$","142.188.56.66");

	String userDataJson = "{\"username\":\"Michele\",\"password\":\"TestPwd1$\",\"ipAddress\":\"142.188.56.66\"}";


	@Test
	public void testUserLogin() throws Exception {

		GeoLocationData geoLocationData = new GeoLocationData();
				geoLocationData.setCountry("Canada");
				geoLocationData.setCity("Toronto");
				geoLocationData.setQuery("142.188.56.66");

		Mockito.when(userAccountService.getGeoLocation(Mockito.anyString())).thenReturn(geoLocationData);

		// Send course as body to /students/Student1/courses
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/register")
				.accept(MediaType.APPLICATION_JSON).content(userDataJson)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

}
