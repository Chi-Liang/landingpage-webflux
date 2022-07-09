package com.hanye.mail.landingpagewebflux;

import org.junit.Test;
import org.springframework.http.MediaType;


public class LandingpageWebfluxApplicationTests extends AbstractTest {
	
	@Test
	public void testSendMail() {
		
		webClient.post()
	      .uri("/api/sendmail")
	      .contentType(MediaType.APPLICATION_JSON)
	      .exchange()
          .expectStatus()
          .isOk()
          .expectBody()
          .jsonPath("$.result").isEqualTo("success")
          .jsonPath("$.msg").isEmpty();
		
	}
	
}
