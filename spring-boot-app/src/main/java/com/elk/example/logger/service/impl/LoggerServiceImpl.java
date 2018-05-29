package com.elk.example.logger.service.impl;

import org.springframework.stereotype.Component;

import com.elk.example.aop.TrackTime;
import com.elk.example.logger.service.LoggerService;

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

}
