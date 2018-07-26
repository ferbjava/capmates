package com.capgemini.capmates;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PlayerGamesAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(PlayerGamesAspect.class);

	@Before("execution(* com.capgemini.capmates.Service.PlayerGamesServiceImpl.addGameToUserCollection(..))")
	public void beforeAddingGame() {
		LOGGER.info("New game is added");
	}

	@Around("execution(* com.capgemini.capmates.DAO.*.*(..))")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		LOGGER.info("Method from any repository will be started");
		Object output = pjp.proceed();
		LOGGER.info("Method finished.");
		long elapsedTime = System.currentTimeMillis() - start;
		LOGGER.info("Method executed in: " + elapsedTime + "milliseconds.");
		return output;
	}
}
