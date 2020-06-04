package com.ex02.library.component;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LibraryAspect {

	@Before("execution(* com.ex02.library.service.LibraryServiceImpl.*(..) )")
	public void beforeBorrowAdvice(JoinPoint joinpoint) {
		System.out.println("beforeBorrowAdvice");
		System.out.println( joinpoint.getSignature().getName() );
	}

	@After("execution(* com.ex02.library.service.LibraryServiceImpl.*(..) )")
	public void afterBorrowAdvice(JoinPoint joinpoint) {
		System.out.println("afterBorrowAdvice"); System.out.println(joinpoint.getSignature().getName() );
	}
	  
	@AfterThrowing(pointcut =  "execution(* com.ex02.library.service.LibraryServiceImpl.*(..) )", throwing = "error")
	public void afterThrowingAdvice(JoinPoint jp, Throwable error) {
		System.out.println("afterThrowingAdvice ......");

		System.out.println("Exception: "+error);
	}
	 
}
