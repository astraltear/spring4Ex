package com.youngjee.springcore.aop2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAOP2 {
	
	/*
	aspectj pointcut 표현식
	
	*	:	 모든
	.	:	현재
	..	:	0개 이상
	
	@Pointcut("execution(public void get*(..))")		public void 인 모든 get 메소드
	@Pointcut("execution(* com.javalec.ex.*.*())")		com.javalec.ex 패키지에 파라미터가 없는 모든 메소드
	@Pointcut("execution(* com.javalec.ex..*.*())")		com.javalec.ex 패키지 & com.javalec.ex 하위 패키지에 파라미터가 없는 메소드
	@Pointcut("execution(* com.javalec.ex.Worker.*())")	com.javalec.ex.Worker 안의 모든 메소드
	
	@Pointcut("within(com.javalec.ex.*)")				com.javalec.ex 패키지 안에 있는 모든 메소드
	@Pointcut("within(com.javalec.ex..*)")				com.javalec.ex 패키지 및 하위 패키지의 모든 메소드
	@Pointcut("within(com.javalec.ex.Worker)")			com.javalec.ex.Worker의 모든 메소드 
	
	 */
	
	@Pointcut("within(com.youngjee.springcore.aop2.*)")
	private void pointcutMethod() {
		System.out.println("pointcutMethod() call <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}
	
	
	@Around("pointcutMethod()")
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(signatureStr+"is start!!!!!!!!!!!");
		
		long st= System.currentTimeMillis();
		
		try {
			Object obj = joinpoint.proceed();
			return obj;
		} finally {
			long ed = System.currentTimeMillis();
			System.out.println(signatureStr+"is finished!!!!!!!");
			System.out.println(signatureStr+" elapse time:"+(ed-st));
		}
	}
	
	
	@Before("within(com.youngjee.springcore.aop2.*)")
	public void beforeAdvice() {
		System.out.println("beforeAdvice()>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}

}
