package com.sarthak.learn_spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * This .java file is part of the learn-spring-framework project.
 * It demonstrates the use of Spring Framework for dependency injection and bean management.
 * 
 * What I learned till now:
 * - How to create a Spring configuration class using @Configuration annotation.
 * - How to define beans using @Bean annotation.
 * - Different ways to inject dependencies into beans (method call injection, parameterized methods).
 * - record types in Java for simple data carriers. 
 * 
 * @author Sarthak Saini
 * @version 1.0
 * @since 2024-06-15
 */

// Simple record classes to represent Person and Address entities
record Person (String name, int age) {} ;
record Address (String street, String city) {} ;

@Configuration
public class HelloWorldConfiguration {

    // Normal bean methods.
    @Bean
    public String name() {
        return "First Spring Application made by Sarthak Saini!!!! Hurrah Progressing well...";
    }

    @Bean
    public int age() {
        return 22;
    }

    // Beam method with custom name.
    @Bean(name = "Human")
    public Person person() {
        return new Person("Sam", 24);
    }

    @Bean
    public Address address() {
        return new Address("123 Main St", "Perth");
    }   

    // Beam method with method call injection
    @Bean
    public Person person2MethodCall() {
      return new Person(name(),age());
    }
    
    // Beam method with parameters
    @Bean
    public Person person3Parameters(String name, int age) {
        return new Person(name, age);
    }

}
