package com.elk.example.domain.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum LogLevelType {

	
	TRACE(){

		@Override
		public void log(String message) {
			super.LOGGER.trace(message);
		}
		
	},
	DEBUG(){
		@Override
		public void log(String message) {
			super.LOGGER.debug(message);
		}
	},
	INFO(){
		@Override
		public void log(String message) {
			super.LOGGER.info(message);
		}
	},
	WARN(){
		@Override
		public void log(String message) {
			super.LOGGER.warn(message);
		}
	},
	ERROR(){
		
		@Override
		public void log(String message) {
			super.LOGGER.trace(message);
		}
	};
	
	public void log(String message) {
		
		LOGGER.debug(message);;
		
	}
	
	private Logger LOGGER;
	private String logLevel;
	

	LogLevelType (){
		this.LOGGER = LoggerFactory.getLogger("elk-logger");
	}

	
}
