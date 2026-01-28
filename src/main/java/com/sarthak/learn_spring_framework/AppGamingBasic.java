package com.sarthak.learn_spring_framework;

import com.sarthak.learn_spring_framework.game.GameRunner;
import com.sarthak.learn_spring_framework.game.MarioGame;
import com.sarthak.learn_spring_framework.game.SuperContraGame;

public class AppGamingBasic {
    public static void main(String[] args) {
       
        var game = new MarioGame();
        var game1 = new SuperContraGame();

        var gameRunner = new GameRunner(game);
        gameRunner.run();

        var gameRunner1 = new GameRunner(game1);
        gameRunner1.run();
        
    }

}
