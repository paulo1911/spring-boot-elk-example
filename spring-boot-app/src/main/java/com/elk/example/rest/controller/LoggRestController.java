package com.elk.example.rest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elk.example.domain.model.LogModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(path = {"/api/log" }, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "ELK test API", description = "API for ELK test Integration", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoggRestController {
	
	
	
	@ApiOperation(value = "Add a Log Line", response = LogModel.class)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> genLog(@ModelAttribute LogModel log, HttpServletRequest request) {
		
		if(log.getRepeat() > 0) {
			final String message = log.getMessage();
			for(int i=0;i < log.getRepeat(); i++) {
				
				log.setMessage(message + " " + i );
				
				log.getLogLevel().log(log.toString());
				
				try {
					Thread.sleep(Double.valueOf(Math.random() * 50).longValue());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		} else {
			
			log.getLogLevel().log(log.toString());
		}
		
		
		
		return ResponseEntity.ok("ok!!!!!").status(HttpStatus.ACCEPTED).build();
	}
}