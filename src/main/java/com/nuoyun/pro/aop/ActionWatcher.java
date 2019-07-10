package com.nuoyun.pro.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: ActionWatcher.java
 * @Package com.nuoyun.pro.aop
 * @Description: action watcher
 * @author: zhangwei
 * @date: 2019-07-10
 * @version V1.0
 * @Copyright: 2019 nuoyun All rights reserved.
 */
@Component
@Slf4j
@Aspect
public class ActionWatcher {
	/**
	 * @Title: pointCut @Description: TODO(描述这个方法的作用) @author:zhangwei 
	 * >> execution
	 * >>表达式的主体 第一个* 代表任意的返回值 com.nuoyun.pro.action aop所横切的包名 包后面.. 表示当前包及其子包
	 *         第二个* 表示类名，代表所有类.*(..) 表示任何方法,括号代表参数 .. 表示任意参数 @date: Jul 10, 2019
	 *         10:01:47 AM @param: @return: void @throws
	 */
	@Pointcut("execution(public * com.nuoyun.pro.action..*.*(..))")
	public void pointCut() {
	}

	@Before("pointCut()")
	public void before() {
		log.info("ActionWatcher pointCut before");
	}
	
	@Around("pointCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("------ watch start -----");
		Signature signature = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		log.info("request {} ",joinPoint.getTarget().getClass().getMethod(methodSignature.getMethod().getName(), methodSignature.getMethod().getParameterTypes()));
		long start = System.nanoTime();
		Object result = joinPoint.proceed();
		long end = System.nanoTime();
		log.info("------ watch end ,cost {} ms ------", (end - start) / (1000 * 1000));
		return result;
	}
	
	@After("pointCut()")
	public void after() {
		log.info("ActionWatcher pointCut after");
	}
}
