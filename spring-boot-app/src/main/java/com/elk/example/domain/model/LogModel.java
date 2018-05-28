package com.elk.example.domain.model;

import java.io.Serializable;
import java.util.UUID;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(of= {"track_id", "message"})
@ApiModel
public class LogModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String track_id;
	private String message;
	private LogLevelType logLevel;
	private int repeat;
	private int overTime;
	
	public String getTrack_id() {
	
		return (track_id !=null) ? track_id : UUID.randomUUID().toString();
	}
}