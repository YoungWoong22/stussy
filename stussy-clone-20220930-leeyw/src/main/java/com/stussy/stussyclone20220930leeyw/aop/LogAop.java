package com.stussy.stussyclone20220930leeyw.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAop {

    @Pointcut("execution(* com.stuusy.stussyclone20220930leeyw.api.*Api.*(..))")
    private void pointCut() {}

    @Pointcut("@annotation(com.stussy.stussyclone20220930leeyw.aop.annotation.LogAspect)")
    private void annotationPointCut() {}

    @Around("annotationPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();

        String className = codeSignature.getDeclaringTypeName();    //type name
        String methodName = codeSignature.getName();                //methodeName
        String[] parameterNames = codeSignature.getParameterNames(); //매계변수 값가져오기
        Object[] args = joinPoint.getArgs(); //parameter 값 가져오는 것

        for(int i=0; i< parameterNames.length; i++){ //log 찍어주기
            log.info("<<<<Parameter info >>>> {}.{} >>> [{}: {}]" , className,methodName,parameterNames[i], args[i]);
            //
        }

        Object result = joinPoint.proceed();

        log.info("<<<< Return >>>> {}.{} >>> [{}: {}]", className,methodName,result);

        return result;
    }


}
