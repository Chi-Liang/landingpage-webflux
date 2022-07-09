package com.hanye.mail.landingpagewebflux.batch;

import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;
import com.hanye.mail.landingpagewebflux.service.MailJobService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MailJob extends QuartzJobBean {
	
	@Autowired
	private MailJobService mailJobService;

	@Override
	protected void executeInternal(JobExecutionContext context) {
		
		try {
			mailJobService.startMailJob();
		} catch (Exception e) {
			log.error("send mail fail : ", e);
		}
		
	}

}
