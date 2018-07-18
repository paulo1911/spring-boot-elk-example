package com.elk.example.rest.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elk.example.domain.model.LogModel;
import com.elk.example.logger.service.LoggerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(path = {"/api/log" }, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "ELK test API", description = "API for ELK Integration tests", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoggRestController {
	
	private LoggerService loggerService;
	
	public LoggRestController(LoggerService loggerService) {
		this.loggerService = loggerService;
	}
	
	@ApiOperation(value = "Add a Simple Log Line", response = LogModel.class)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<LogModel> genLog(@RequestBody LogModel logModel) {
		
		loggerService.pubLogMessage(logModel);
		
		return ResponseEntity.accepted().body(logModel);
	}
}
