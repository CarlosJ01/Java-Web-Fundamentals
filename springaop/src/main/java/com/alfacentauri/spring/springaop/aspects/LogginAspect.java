package com.alfacentauri.spring.springaop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogginAspect {
	
	@Before("execution(* com.alfacentauri.spring.springaop.ProductServiceImp.multiply(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("Before calling method");
	}
	
	@After("execution(* com.alfacentauri.spring.springaop.ProductServiceImp.multiply(..))")
	public void logAfter(JoinPoint joinPoint) {
		System.err.println("After the method execution");
	}
	
	
}
