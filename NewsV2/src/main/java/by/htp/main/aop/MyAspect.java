package by.htp.main.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import by.htp.main.bean.News;

@Aspect
@Component
public class MyAspect {

	@Before("by.htp.main.aop.MyPointcuts.forDaoPackage()")
	public void beforeDaoAdvise(JoinPoint theJoinPoint) {

		MethodSignature theMethodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method of NewsDAO : " + theMethodSignature);
		Object[] args = theJoinPoint.getArgs();
		for (Object arg : args) {
			System.out.println("args of NewsDAO Method : " + arg);
			if (arg instanceof News) {
				News theNews = (News) arg;
				System.out.println("News Title : " + theNews.getTitle());
				System.out.println("Author : " + theNews.getUser().getLogin() + "|| authors ID : "
						+ theNews.getUser().getUserId());
			}
		}
	}

	@Before("by.htp.main.aop.MyPointcuts.forController()")
	public void beforeController(JoinPoint theJoinPoint) {

		MethodSignature theMethodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("<<<Methods of Controller<<< : " + theMethodSignature);
		Object[] args = theJoinPoint.getArgs();
		for (Object arg : args) {
			System.out.println("<<<args of Controller<<< : " + arg);
		}
	}

	@After("by.htp.main.aop.MyPointcuts.forController()")
	public void AfterController(JoinPoint theJoinPoint) {

		MethodSignature theMethodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println(">>>Methods of Controller>>> : " + theMethodSignature);
		Object[] args = theJoinPoint.getArgs();
		for (Object arg : args) {
			System.out.println(">>>args of Controller>>> : " + arg);
		}
	}

}
