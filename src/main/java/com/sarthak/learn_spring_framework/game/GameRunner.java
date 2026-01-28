package com.sarthak.learn_spring_framework.game;

public class GameRunner {   
    
    private GamingConsole game;

    public GameRunner(GamingConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Output ----> Running game: " + game);
        game.up();
        game.down();
        game.left();
        game.right();
    }


}
