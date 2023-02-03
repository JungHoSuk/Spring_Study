package com.example.ex03.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
@Slf4j
public class Plus10Aspect {

    @Around("@annotation(com.example.ex03.aspect.Plus10)")
    public Integer aroundPlus10(ProceedingJoinPoint proceedingJoinPoint){
        Integer result = null;
        try {
            result = (Integer)proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return result + 10;
    }
}
