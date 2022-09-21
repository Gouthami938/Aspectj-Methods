package com.example.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AOPdemo {
@Autowired
ArithmeticOperation operations;     //dependency injection

    public ArithmeticOperation getOperations() {
        return operations;
    }

    public void setOperations(ArithmeticOperation operations) {
        this.operations = operations;
    }

//    @Pointcut("execution(*Employee.*(..))")
   @Pointcut("execution(* com.example.aspectj.ArithmeticOperation.arithmeticMethods())")
    public void display() {
    }

    @Before("display()")
    public void beforeMethod() {
        System.out.println("Before Advice 'Firstnumber' is assigned to : "+operations.numberOne_initial);
        System.out.println("Before Advice 'Secondnumber' is assigned to: "+operations.numberTwo_initial);
      //  System.out.println("Addition of 'Firstnumber' and 'Secondnumber' before Task  : "+(operations.numberOne_initial+operations.numberTwo_initial));

    }

    @After("execution(* com.example.aspectj.ArithmeticOperation.arithmeticMethods())")
    public void afterMethod() {
        System.out.println("After Advice 'Firstnumber' is assigned to : "+this.operations.getNumberOne_initial());
        System.out.println("After Advice 'Secondnumber' is assigned to: "+this.operations.getNumberTwo_initial());
        if(this.operations.getNumberOne_initial()>0&this.operations.getNumberTwo_initial()>0) {
            System.out.println("After Advice: Addition : "
                                        + (this.operations.getNumberOne_initial() + this.operations.getNumberTwo_initial())
                    + " Subtraction : " + (this.operations.getNumberOne_initial() - this.operations.getNumberTwo_initial())
                    + " Multiplication : " + (this.operations.getNumberOne_initial() * this.operations.getNumberTwo_initial())
                    + " Division : " + (this.operations.getNumberOne_initial() / this.operations.getNumberTwo_initial())
            );
        }
    }

    @AfterReturning(value = "execution(* com.example.aspectj.ArithmeticOperation.arithmeticMethods())")
    public void afterreturning(JoinPoint joinPoint){
        System.out.println();
        System.out.println("additional concern");
        System.out.println("Method Signature:" + joinPoint.getSignature());
        System.out.println("end of after returning advice...");
    }


    @Around("execution(* com.example.aspectj.ArithmeticOperation.arithmeticMethods())")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Additional Concern Before calling actual method");
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("Additional Concern After calling actual method");
        return obj;
    }


    @AfterThrowing(value = "execution(* com.example.aspectj.ArithmeticOperation.arithmeticMethods())")
    public void afterthrowing(JoinPoint joinPoint) {
        System.out.println("additional concern");
        System.out.println("Method Signature:" + joinPoint.getSignature());
        System.out.println("end of after throwing advice...");
    }
    
}