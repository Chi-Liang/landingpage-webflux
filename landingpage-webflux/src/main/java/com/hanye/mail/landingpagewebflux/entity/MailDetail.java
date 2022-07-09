package com.hanye.mail.landingpagewebflux.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Table("MAIL_DETAIL")
public class MailDetail {
	
	@Id
	@Column
	private Long id;
	
	@Column
	private String title;
	
	@Column
	private String body;

	public MailDetail(String title, String body) {
		super();
		this.title = title;
		this.body = body;
	}

}
