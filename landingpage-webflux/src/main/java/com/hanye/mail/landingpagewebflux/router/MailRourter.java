package com.hanye.mail.landingpagewebflux.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.hanye.mail.landingpagewebflux.handler.MailHandler;

@Component
public class MailRourter {
	
	@Autowired
	private MailHandler mailHandler;
	
	@Bean
	public RouterFunction<ServerResponse> orderRouters(){
		return RouterFunctions
				.route(RequestPredicates.POST("/api/sendmail"),mailHandler::sendMailJob);
		
	}
	
}
