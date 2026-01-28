package com.sarthak.learn_spring_framework.game;
/**
 * GameRunner class that runs a game implementing the GamingConsole interface.
 * 
 * Concept Learned:
 * - I used Tight Coupling before to directly instantiate specific game classes within the GameRunner.
 *   For example, I had code like:
 *  ``` 
 *  public class GameRunner {
 *     private MarioGame game;  
 *    public GameRunner() {
 *      this.game = new MarioGame(); // Tight Coupling
 *  }
 *  ```
 *  ^-- This made the game runner class dependent on specific game implementations, reducing flexibility and reusability.
 * 
 * - To improve this, I applied Gaming Console interface to achieve Loose Coupling.
 *   Now, the GameRunner class depends on the GamingConsole interface rather than specific game implementations.
 *   This allows me to pass any game that implements the GamingConsole interface to the GameRunner.
 */

public class GameRunner {   

    // Instead of particular game, we are now depending on the GamingConsole interface
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
