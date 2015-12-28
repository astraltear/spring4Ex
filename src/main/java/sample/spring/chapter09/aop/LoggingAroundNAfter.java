package sample.spring.chapter09.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggingAroundNAfter {
	
//	관점으로 사용할 클래스 작성
//	클래스에 공통 관심사 구현 추가
//	정규식을 사용해 공통 관심사가 적용될 메서드 지정 
	
	private static Logger logger = LoggerFactory.getLogger(LoggingAroundNAfter.class); 
	
	
	@Pointcut(value="execution(* sample.spring.chapter09.aop.AopService2.afterAdviceTest(..))")
	public void aftterAdviceMethods() {}
	
	@After(value="aftterAdviceMethods()")
	public void afterAdvice(JoinPoint joinPoint) {
		logger.info("LoggingAroundNAfter afterAdvice MethodName: "+joinPoint.getSignature().getName());
	}
	
	@Around(value="execution(* sample.spring.chapter09..AopService2.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) {
		Object obj = null;
		StopWatch watch = new StopWatch();
		watch.start();
		
		try {
			obj = pjp.proceed();
		} catch (Exception e) {
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		watch.stop();
		logger.info(watch.prettyPrint());
		return obj;
	}
	
}
