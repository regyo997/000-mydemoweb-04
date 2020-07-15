package com.mydemoweb.simpleweb.aspect;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Around("com.mydemoweb.simpleweb.aspect.AopExpressions.doLoginCheck()")
	public String loginCheck(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		HttpSession session=null;
		for(Object obj:theProceedingJoinPoint.getArgs()) {
			if(obj instanceof HttpSession)
				session=(HttpSession)obj;
		}
		if(session==null||session.getAttribute("currUser")==null) 
			return "/login/login";
		else
			return (String)theProceedingJoinPoint.proceed();
	}
	
}
