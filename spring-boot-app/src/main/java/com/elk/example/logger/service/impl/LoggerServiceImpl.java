package com.elk.example.logger.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import com.elk.example.aop.TrackTime;
import com.elk.example.domain.model.LogModel;
import com.elk.example.logger.service.LoggerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableAsync
@Component(value="trackTime")
public class LoggerServiceImpl implements LoggerService{

	@Override
	@TrackTime(value="methodTimeTracked")
	public void genTrackTime() {
		

		try {
			Thread.sleep(Double.valueOf(Math.random() * 512).longValue());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	@Async
	public LogModel pubLogMessage(LogModel logModel) {
		
		logModel.getLogLevel().log(logModel.toString());
		
		if(logModel.getRepeat() > 0) {
			final String message = logModel.getMessage();
			for(int i=1;i <= logModel.getRepeat(); i++) {
				
				logModel.setMessage(message + " " + i );
				
				logModel.getLogLevel().log(logModel.toString());
				
				try {
					Thread.sleep(Double.valueOf(Math.random() * 1050).longValue());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			logModel.setMessage(message);
			
		} else {
			
			logModel.getLogLevel().log(logModel.toString());
		}
		
		return logModel;
	}

}
