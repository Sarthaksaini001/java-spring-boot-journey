package com.sarthak.learn_spring_framework.game;

// SuperContraGame class implementing the GamingConsole interface
public class SuperContraGame implements GamingConsole {

    public void up(){
        System.out.println("up - jump with a gun");
    }
    public void down(){
        System.out.println("down - go prone");
    }
    public void left(){
        System.out.println("left - move left");
    }
    public void right(){
        System.out.println("right - move right");
    }
}
