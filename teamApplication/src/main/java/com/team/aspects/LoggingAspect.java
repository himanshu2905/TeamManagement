package com.team.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.team.domain.Team;

@Component
@Aspect
public class LoggingAspect {

	private static Logger logger = Logger.getLogger(LoggingAspect.class);

	//before and after
	//execution(* com.xyz.service.AccountService.*(..))
	@Around("execution(* com.team.services.TeamServiceImpl.*(..))")
	//@Before(you can use JoinPoint instead of ProceedingJoinPoint)
	//@After(you can use JoinPoint instead of ProceedingJoinPoint)
	//@AfterReturning - your method should return a value
	//@AfterThrowing -executes when ever there is an exception
	public Object printMethodNameWithArgs(ProceedingJoinPoint pjp) throws Throwable {
		Object[] args = pjp.getArgs();
		if (args.length > 0) {
			if (args[0] instanceof Team) {
				logger.info(
						"Executing " + pjp.getSignature().getName() + "with arguments " + ((Team) args[0]).toString());
			}
		} else {
			logger.info("Executing " + pjp.getSignature().getName());
		}
		Object obj = pjp.proceed();
		if (args.length > 0) {
			if (args[0] instanceof Team) {
				logger.info("Execution Finished " + pjp.getSignature().getName() + "with arguments "
						+ ((Team) args[0]).toString());
			}
		} else {
			logger.info("Execution finished for " + pjp.getSignature().getName());
		}
		return obj;
	}
}
