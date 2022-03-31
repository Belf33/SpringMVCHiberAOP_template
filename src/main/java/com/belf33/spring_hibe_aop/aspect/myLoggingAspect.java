package com.belf33.spring_hibe_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class myLoggingAspect {

    @Around("execution(* com.belf33.spring_hibe_aop.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature =
                (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = signature.getName();

        System.out.println("begin of " + methodName);

        Object targetMethodResult = proceedingJoinPoint.proceed();

        System.out.println("End of " + methodName);

        return targetMethodResult;
    }
}
