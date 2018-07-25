package com.capgemini.capmates;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PlayerGamesAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(PlayerGamesAspect.class);

	@Before("execution(* com.capgemini.capmates.Service.PlayerGamesServiceImpl.addGameToUserCollection(..))")//konkretna metoda
//	@Before("execution(* com.capgemini.capmates.Service.PlayerGamesServiceImpl.(..))")//wszystkie metody dla dowolnej ilosci argumentow
	public void beforeAddingGame() {
		LOGGER.info("New game is added");
	}
}
