package com.mckesson.connect.portal.rnaservice.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;

import com.mckesson.connect.portal.deleteservice.PortalDeleteServiceApplication;
import com.mckesson.connect.portal.rnaservice.AbstractControllerTest;

@ContextConfiguration(loader = SpringBootContextLoader.class, classes = PortalDeleteServiceApplication.class)
public class RnaAdminControllerTest extends AbstractControllerTest {

	@Test
	@WithMockUser(username = "_TEST_")
	public void test() throws Exception {
		this.mockMvc
				.perform(get("/swagger-ui.html"))
				.andDo(print())
				.andExpect(status().isOk())
				;
	}
}
