package com.hanye.mail.landingpagewebflux.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hanye.mail.landingpagewebflux.repository.MailRepository;

import ch.qos.logback.core.net.SyslogOutputStream;


@Service
public class MailJobService {
	
	@Autowired
	JobLauncher jobLauncher;
	
	@Qualifier("sendMailJob")
	@Autowired
	Job sendMailJob;
	
	@Autowired
	protected MailRepository mailRepository;
	
	public void startMailJob() throws Exception {
		
		var jobParameters = new JobParameters(new HashMap<String, JobParameter>(){
			private static final long serialVersionUID = 1431431752012518702L;
		{
			put("currentTime", new JobParameter(System.currentTimeMillis()));
		}});
		
		jobLauncher.run(sendMailJob, jobParameters);
			
	}
	
}
