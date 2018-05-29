package com.elk.example.aop;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TrackTime {

	String value() default "";
	
	@Aspect
	@Configuration
	public class MethodExecutionCalculationAspect {

		private Logger logger = LoggerFactory.getLogger(TrackTime.class);
		
		

		@Around("@annotation(com.elk.example.aop.TrackTime)")
		public void around(ProceedingJoinPoint joinPoint) throws Throwable {
			StopWatch startTime = new StopWatch();
			startTime.start();
			joinPoint.proceed();

			startTime.stop();
			MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		    Method method = signature.getMethod();
		    
			TrackTime trackAnnotation = method.getAnnotation(TrackTime.class);
			String value = trackAnnotation.value();
			
		
			
			logger.info("time[{}:{}]", value, startTime.getTotalTimeMillis());
		}
	}
}
