package sample.spring.chapter09.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingThrowing {
	
//	관점으로 사용할 클래스 작성
//	클래스에 공통 관심사 구현 추가
//	정규식을 사용해 공통 관심사가 적용될 메서드 지정 
	
	private static Logger logger = LoggerFactory.getLogger(LoggingThrowing.class); 
	
	@Pointcut(value="execution(* sample.spring.chapter09.aop.AopService2.callExcept(..))")   // POINTCUT
	public void exceptionMethods() {}
	
	
	@AfterThrowing(value="exceptionMethods()", throwing="exception")  
	public void afterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {	
		logger.info("LoggingThrowing Call ClassName: "+joinPoint.getTarget().getClass().getSimpleName());
		logger.info("LoggingThrowing Call MethodName: "+joinPoint.getSignature().getName());
		logger.info("LoggingThrowing Call exception: "+exception);
		
		Object [] objs = joinPoint.getArgs();
		
		for (int i = 0; i < objs.length; i++) {
			logger.info("objs["+i+"] -->"+objs[i]);
		}
	}
	
	
}
