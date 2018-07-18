package com.elk.example.domain.model;

import java.io.Serializable;
import java.util.UUID;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(value=Include.NON_NULL)
public class LogModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(dataType="string", required=false, example="UUID-123456-XYZ")
	private String track_id;
	
	@NotBlank
	@Size(min=1, max=255)
	@ApiModelProperty(dataType="String", required=true, example="Message to see in the log")
	private String message;
	
	@NotNull
	@ApiModelProperty(dataType="String", required=true, example="INFO", allowableValues="TRACE, DEBUG, INFO, WARN, ERROR")
	private LogLevelType logLevel;
	
	@Max(value=1000)
	@ApiModelProperty(dataType="int", required=false, example="5", value="0")
	private int repeat;

	
	public String getTrack_id() {
	
		return (track_id !=null) ? track_id : UUID.randomUUID().toString();
	}
}