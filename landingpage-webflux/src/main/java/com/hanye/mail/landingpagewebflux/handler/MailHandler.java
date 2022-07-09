package com.hanye.mail.landingpagewebflux.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.hanye.mail.landingpagewebflux.response.MailResponse;
import com.hanye.mail.landingpagewebflux.service.MailJobService;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class MailHandler {
	
	@Autowired
	private MailJobService mailJobService;
	
	public Mono<ServerResponse> sendMailJob(ServerRequest serverRequest){
		
		Mono<MailResponse> mailResponse = Mono.empty();
		
		try {
			mailJobService.startMailJob();
			mailResponse = Mono.just(new MailResponse("success", ""));
		} catch (Exception e) {
			log.error("send mail fail : ", e);
			mailResponse = Mono.just(new MailResponse("fail", e.getMessage()));
		}
		
		
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(mailResponse,MailResponse.class);
	}

	
}
