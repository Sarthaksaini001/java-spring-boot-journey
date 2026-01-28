package com.sarthak.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/** 
 * This class demonstrates the use of Spring Framework to manage beans and dependencies.
 * 
 * Things I learned :
 * - How to launch a Spring application context using AnnotationConfigApplicationContext.
 * - How to retrieve beans from the Spring context using getBean() method.
 * 
 * Important Errors to remember:
 * - when using getBean() with class type parameter, For eg, I used context.getBean(Person.class)
 *   But there is 2 beans of type Person present in the context, So it will throw NoUniqueBeanDefinitionException.
 *  
 * @author Sarthak Saini
 * @version 1.0
 * @since 2024-06-15
 */
public class App02HelloWoeldSpring {
    public static void main(String[] args) {

    // Launch a spring context - This code is used to launch the spring application context
    var context= new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
    
    // Configure the things that we want spring to manage - @Configuration
    System.out.println(context.getBean("name"));
    System.out.println(context.getBean("age"));
    System.out.println(context.getBean("Human"));
    // Passing parameter as class type to get bean of that particular class type
    System.out.println(context.getBean(Address.class));
    System.out.println(context.getBean("address"));
    System.out.println(context.getBean("person2MethodCall"));
    System.out.println(context.getBean("person3Parameters"));
 
    }

}
