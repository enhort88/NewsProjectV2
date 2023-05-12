package by.htp.main.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyPointcuts {
	
	@Pointcut("execution (* by.htp.main.dao.impl.NewsDAOImpl.*(..))")
	  
	  public void forDaoPackage() {}
	
	@Pointcut("execution (* by.htp.main.controller.ApplicationController.*(..))")
	  
	  public void forController() {}

}
