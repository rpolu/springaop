package com.elegant.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Before("execution(* com.elegant.spring.aop.service.EmployeeService.simpleMethod(..))")
	public void beforeExecution(JoinPoint jp) {
		System.out.println("Before method: " + jp.getSignature().getName() + ". Class: "
				+ jp.getTarget().getClass().getSimpleName());
	}

	@AfterReturning(pointcut = "execution(* com.elegant.spring.aop.service.EmployeeService.methodReturnsValue(..))", returning = "result")
	public void afterReturningExecution(JoinPoint jp, Object result) {
		System.out.println("After returning method: " + jp.getSignature().getName() + ". Class: "
				+ jp.getTarget().getClass().getSimpleName());
		System.out.println("Result returned: " + result);
	}

	@AfterThrowing(pointcut = "execution(* com.elegant.spring.aop.service.EmployeeService.methodThrowsException(..))", throwing = "ex")
	public void afterThrowingExecution(JoinPoint jp, Exception ex) {
		System.out.println("After throwing method: " + jp.getSignature().getName() + ". Class: "
				+ jp.getTarget().getClass().getSimpleName());
		System.out.println("Exception: " + ex.getMessage());
	}

	@After("execution(* com.elegant.spring.aop.service.EmployeeService.simpleMethod(..))")
	public void afterExecution(JoinPoint jp) {
		System.out.println("After method: " + jp.getSignature().getName() + ". Class: "
				+ jp.getTarget().getClass().getSimpleName());
	}

	@Around("execution(* com.elegant.spring.aop.service.EmployeeService.testAround*(..))")
	public Object aroundExecution(ProceedingJoinPoint jp) throws Exception {

		System.out.println("Before method: " + jp.getSignature().getName() + ". Class: "
				+ jp.getTarget().getClass().getSimpleName());

		try {
			// Proceed with method invocation
			Object result = jp.proceed();

			System.out.println("Returning: " + result);
			return result;
		} catch (Throwable e) {
			// Log error
			System.out.println("Error: " + e.getMessage());
			// Throw exception to the caller
			throw new Exception("Error", e);
		}
	}
}
