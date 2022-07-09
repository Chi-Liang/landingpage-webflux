package com.hanye.mail.landingpagewebflux.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailResponse {
	
	private String result;
	private String msg;
	
}
