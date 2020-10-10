package com.guipernicone.pbs.Security.Controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AuthenticationControllerTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void userAuthenticationErrorTest() throws Exception {
		assertNotNull(this.restTemplate.getForObject("http://localhost:" + port + "/auth/user", String.class));
		assertTrue(this.restTemplate.getForObject("http://localhost:" + port + "/auth/user", String.class).contains("\"status\":405"));
	}
}
