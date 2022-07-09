package com.hanye.mail.landingpagewebflux;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.hanye.mail.landingpagewebflux.repository.MailRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebTestClient
public class AbstractTest {
	
	@Autowired
	protected WebTestClient webClient;
	
	@Autowired
	protected MailRepository mailRepository;
	
	
}
