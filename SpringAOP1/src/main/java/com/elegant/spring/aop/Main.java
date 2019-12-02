package com.elegant.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.elegant.spring.aop.service.EmployeeService;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		EmployeeService exampleBean = (EmployeeService) ctx.getBean("employeeService");

		exampleBean.simpleMethod();
		Object result = exampleBean.methodReturnsValue();
		try {
			exampleBean.methodThrowsException();
		} catch (Exception e) {
			System.out.println("Exception caught in Main: " + e.getMessage());
		}
		result = exampleBean.testAroundReturningResult();
		try {
			exampleBean.testAroundThrowingException();
		} catch (Exception e) {
			System.out.println("Exception caught in Main: " + e.getMessage());
		}
		ctx.close();

	}
}
