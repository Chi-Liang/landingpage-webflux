package com.hanye.mail.landingpagewebflux.config;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.hanye.mail.landingpagewebflux.batch.MailJob;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail jobDetailSendMail(){
        return JobBuilder.newJob(MailJob.class).storeDurably().build();
    }
    
    @Bean
    public Trigger trigger1(){
        return TriggerBuilder.newTrigger()
                .forJob(jobDetailSendMail())
                .withSchedule(CronScheduleBuilder.cronSchedule("* * 1 ? * *"))
                .build();
    }

}