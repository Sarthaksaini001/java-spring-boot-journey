package com.sarthak.learn_spring_framework;

import com.sarthak.learn_spring_framework.game.GameRunner;
import com.sarthak.learn_spring_framework.game.MarioGame;
import com.sarthak.learn_spring_framework.game.SuperContraGame;

/**
 * This is a simple Java application that demonstrates the use of interfaces and classes.
 * It includes two gaming consoles: MarioGame and SuperContraGame, both implementing the GamingConsole interface.
 * The GameRunner class is used to run the games by invoking their methods.
 * 
 * @author Sarthak Saini
 * @version 1.0
 * @since 2024-06-15
 */

public class App01GamingBasic {
    public static void main(String[] args) {
       
        // Create instances of the games
        var game = new MarioGame();
        var game1 = new SuperContraGame();

        
        // Create GameRunner instances and run the games
        var gameRunner = new GameRunner(game);
        gameRunner.run();

        var gameRunner1 = new GameRunner(game1);
        gameRunner1.run();
        
    }

}
