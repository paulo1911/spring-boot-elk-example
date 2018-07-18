package com.elk.example.job;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Configuration
@EnableScheduling
@Component
@Slf4j
@Profile("job")
public class LoggerJob {

	
	@Scheduled(fixedDelay=1010)
	public void generateDebugLogs() {
		
		log.debug("DEBUG LOG GENERATED");
		
	}
	
	@Scheduled(fixedDelay=1020)
	public void generateInfoLogs() {
		
		log.info("INFO LOG GENERATED");
		
	}
	
	@Scheduled(fixedDelay=1040)
	public void generateWarnLogs() {
		
		log.warn("WARN LOG GENERATED");
		
	}
	
	@Scheduled(fixedDelay=100000)
	public void generateErrorLogs() {
		
		log.error("ERROR LOG GENERATED");
		
	}
	
}
