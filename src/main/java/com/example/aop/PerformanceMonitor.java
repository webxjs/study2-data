package com.example.aop;

import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitor{
	@Around("execution(* com.example.service..*(..))")
	public Object collectExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		Date date = new Date();
		System.out.println("The method " + joinPoint.getSignature().getName() + "() begins with " + Arrays.toString(joinPoint.getArgs()));
	    try
	    {
	        Object result = joinPoint.proceed();
	        System.out.println("The method " + joinPoint.getSignature().getName() + "() consume time " + (new Date().getTime() - date.getTime()) + " ms");
	        return result;
	    }
	    catch (IllegalArgumentException e)
	    {
	    	System.out.println("Illegal argument " + Arrays.toString(joinPoint.getArgs()) + " in " + joinPoint.getSignature().getName() + "()");
	        throw e;
	    }
   }
}