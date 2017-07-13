package com.beauty.application;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * beauty main entrance
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.beauty.*")
public class Application {

    public static void main(String... args) throws NoSuchMethodException, MalformedURLException, InvocationTargetException, IllegalAccessException {

    	    ApplicationContext ctx = SpringApplication.run(Application.class, args);
    	    String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();  
    	    for (String profile : activeProfiles) {  
    	    	System.out.println("Spring Boot 使用profile为: application-"+ profile+".yml");  
    	    } 
    }

}
