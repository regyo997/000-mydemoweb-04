package com.mydemoweb.simpleweb.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	
	@Pointcut("execution(* com.mydemoweb.simpleweb.controller.*.*(..))")
	public void controllers() {}
	
	@Pointcut("execution(* com.mydemoweb.simpleweb.controller.CartController.*Cart*(..))")
	public void cartControllerCart() {}
	
	@Pointcut("execution(* com.mydemoweb.simpleweb.controller.LoginController.*(..))")
	public void loginController() {}
	
	@Pointcut("execution(* com.mydemoweb.simpleweb.controller.ProductController.*(..))")
	public void productController() {}
	
	@Pointcut("execution(* com.mydemoweb.simpleweb.controller.UserController.showForm*(..))")
	public void userControllerShowFormForAddAndUpdate() {}
	
	@Pointcut("execution(* com.mydemoweb.simpleweb.controller.UserController.saveUser(..))")
	public void userControllerSave() {}
	
	@Pointcut("userControllerShowFormForAddAndUpdate() "
			+ "|| userControllerSave()")
	public void userControllerRegister() {}
	
	@Pointcut("execution(* com.mydemoweb.simpleweb.controller.DemoController.*(..))")
	public void demoController() {}
	
	@Pointcut("controllers()"
			+ "&& !cartControllerCart()"
			+ "&& !loginController()"
			+ "&& !demoController()"
			+ "&& !userControllerRegister()")
	public void doLoginCheck() {}
	
}
