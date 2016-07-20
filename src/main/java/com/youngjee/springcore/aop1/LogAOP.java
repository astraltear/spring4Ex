package com.youngjee.springcore.aop1;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAOP {
//	joinpoint
	public Object loggerAOP(ProceedingJoinPoint joinPoint) throws Throwable {
		String signatureStr = joinPoint.getSignature().toShortString();
		System.out.println(signatureStr+" is start >>>>>>>>>>>>>>>>>>>");
		
		long start = System.currentTimeMillis();
		
		try {
			Object object = joinPoint.proceed();
			return object;
		} finally {
			long end = System.currentTimeMillis();
			System.out.println(signatureStr+" is finish >>>>>>>>>>>>>>>>>>>");
			System.out.println(signatureStr+" elapsed time >>>>>>>>>>>>>>>>>>>"+(end-start));
		}
	}
}
