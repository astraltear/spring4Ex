package sample.spring.chapter09.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingPointCut {
	
//	관점으로 사용할 클래스 작성
//	클래스에 공통 관심사 구현 추가
//	정규식을 사용해 공통 관심사가 적용될 메서드 지정 
	
	private static Logger logger = LoggerFactory.getLogger(LoggingPointCut.class); 
	
	@Pointcut(value="execution(* sample.spring.chapter09.aop.*Service.*(..))")   // POINTCUT
	public void invokeServiceMethods() {}
	
	
	@Before(value="invokeServiceMethods()")  
	public void log(JoinPoint joinPoint) {	
		logger.info("LoggingPointCut Call ClassName: "+joinPoint.getTarget().getClass().getSimpleName());
		logger.info("LoggingPointCut Call MethodName: "+joinPoint.getSignature().getName());
		
		Object [] objs = joinPoint.getArgs();
		
		for (int i = 0; i < objs.length; i++) {
			logger.info("objs["+i+"] -->"+objs[i]);
		}
	}
}
