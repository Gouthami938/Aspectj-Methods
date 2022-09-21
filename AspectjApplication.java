package com.example.aspectj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AspectjApplication {

	public static void main(String[] args) {
		ApplicationContext context =	SpringApplication.run(AspectjApplication.class, args);
		ArithmeticOperation arithmetic_object =(ArithmeticOperation) context.getBean(ArithmeticOperation.class);
		try {
			arithmetic_object.arithmeticMethods();
		} catch (Exception e) {
			System.out.println(e);

		}
	}

}
