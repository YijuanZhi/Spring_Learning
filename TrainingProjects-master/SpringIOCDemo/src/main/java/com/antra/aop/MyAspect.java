package com.antra.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	@After("execution(* com.antra.*.*.get*(..))")
	public void before(JoinPoint joinpoint){
		System.out.println("AOP got called " + joinpoint.getSignature());
	}

	@Around("@annotation(LogTime)")
	public Object aroundSomehting(ProceedingJoinPoint pjp) throws Throwable {
		Long time = System.currentTimeMillis();
		Object obj =  pjp.proceed();
		Long td = System.currentTimeMillis() - time;
		System.out.println("Total time elapsed" + td);
		return obj;
	}
}
