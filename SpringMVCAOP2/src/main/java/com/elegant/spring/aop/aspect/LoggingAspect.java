package com.elegant.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Before("execution(* com.elegant.spring.aop.service.impl.ArticleServiceImpl.articleList(..))")
	public void beforeExecution(JoinPoint jp) {
		System.out.println("Before method: " + jp.getSignature().getName() + ". Class: "
				+ jp.getTarget().getClass().getSimpleName());
	}

}
