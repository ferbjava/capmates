package com.capgemini.capmates.ControllerTests;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void shouldShowPlayerProfile() throws Exception {
		// given
		final String EXPECTED_JSON = "{\"id\":1,\"firstName\":\"Jan\",\"lastName\":\"Kowalski\",\"email\":\"jan.kowalski@gmail.com\",\"password\":\"admin1234\",\"lifeMotto\":\"amdg\"}";
		final int EXPECTED_HTTP_STATUS = HttpStatus.OK.value();

		// when
		MvcResult result = this.mockMvc.perform(get("/profile/1").contentType(MediaType.APPLICATION_JSON)).andReturn();
		String responseString = result.getResponse().getContentAsString();
		int responseStatus = result.getResponse().getStatus();

		// then
		assertEquals(EXPECTED_JSON, responseString);
		assertEquals(EXPECTED_HTTP_STATUS, responseStatus);

	}

	@Test
	public void shouldReturnException() throws Exception {

		// given
		String EXPECTED_RESPONSE = "Invalid Id: 6, invalid request: /profile/6";

		// when

		MvcResult result = this.mockMvc.perform(get("/profile/6").contentType(MediaType.APPLICATION_JSON)).andReturn();
		String responseString = result.getResponse().getContentAsString();

		// then
		assertEquals(EXPECTED_RESPONSE, responseString);

	}
}
