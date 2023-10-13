package com.todoproject.ilyas.todolist.aop;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Log


public class LoggingAspect {


    @Around("execution(* com.todoproject.ilyas.todolist.controller..*(..)))")
    public Object profileControllerMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {


        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();


        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        log.info("-------- Executing "+ className + "." + methodName + "   ----------- ");

        StopWatch countdown = new StopWatch();


        countdown.start();
        Object result = proceedingJoinPoint.proceed();
        countdown.stop();

        log.info("-------- Execution time of " + className + "." + methodName + " :: " + countdown.getTotalTimeMillis() + " ms");

        return result;
    }

}
