package com.elk.example.logger.service;

import com.elk.example.domain.model.LogModel;

public interface LoggerService {

	public void genTrackTime();
	
	public LogModel pubLogMessage(LogModel logModel);
}
