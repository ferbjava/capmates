package com.capgemini.capmates.ControllerTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.capgemini.capmates.Controller.PlayerController;
import com.capgemini.capmates.Service.PlayerProfileServiceImpl;
import com.capgemini.capmates.TO.PlayerProfileTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTestsV02 {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Mock
	private PlayerProfileServiceImpl profileServiceMock;

	@Autowired
	private PlayerController playerController;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(profileServiceMock);
		Mockito.reset(profileServiceMock);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		ReflectionTestUtils.setField(playerController, "playerProfileService", profileServiceMock);
	}

	@Test
	public void shouldReturnAllProfiles() throws Exception {
		// given
		ArrayList<PlayerProfileTO> testProfiles = new ArrayList<>();
		testProfiles.add(new PlayerProfileTO(1, "Jan", "Kowalski", "jan.kowalski@gmail.com", "admin1234", "amdg"));

		Mockito.when(profileServiceMock.showAllPlayersProfiles()).thenReturn(testProfiles);

		// when
		ResultActions action = mockMvc.perform(get("/profile/all"));

		// then
		action.andExpect(status().isOk()).andExpect(jsonPath("$[0].firstName").value("Jan"));
	}

	@Test
	public void shouldEditProfiles() throws Exception {
		// given
		List<PlayerProfileTO> testProfiles = new ArrayList<>();
		testProfiles.add(new PlayerProfileTO(1, "Jan", "Kowalski", "jan.kowalski@gmail.com", "admin1234", "amdg"));
		PlayerProfileTO filter =new PlayerProfileTO(1, "Johny", "", "", "", "");

		Mockito.when(profileServiceMock.showFilteredProfiles(filter).thenReturn(testProfiles);

		// when
		ResultActions action = mockMvc.perform(put("profile/edit"));

		// then
		action.andExpect(status().isOk()).andExpect(jsonPath("$[0].firstName").value("Jan"));
	}

}
