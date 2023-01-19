package com.journal.resultscontrolapigateway;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;

@SpringBootTest
class ResultsControlApiGatewayApplicationTests {

	@Autowired
	WebApplicationContext context;

	@Test
	void contextLoads() {
	}

	@Test
	public void generateSwagger() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		mockMvc.perform(MockMvcRequestBuilders.get("/v2/api-docs").accept(MediaType.APPLICATION_JSON))
				.andDo((result) -> {
					FileUtils.writeStringToFile(new File("target/swagger/swagger.json"), result.getResponse().getContentAsString());
				});

	}

}
