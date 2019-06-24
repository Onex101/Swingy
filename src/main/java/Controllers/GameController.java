package Controllers;

import Models.Game;
import Models.Mobs.Monster;
import Views.Console.GameScreen;

import java.util.Random;

public class GameController {

    private GameScreen gameScreen;
    private Game game;

    public GameController(Game game, GameScreen gameScreen){
        this.gameScreen = gameScreen;
        this.game = game;
    }

    public void onMove(String direction) {
        int x = game.getHeroX();
        int y = game.getHeroY();

        switch (direction.toUpperCase()) {
            case "NORTH":
                y--;
                break;
            case "SOUTH":
                y++;
                break;
            case "WEST":
                x--;
                break;
            case "EAST":
                x++;
                break;
        }

        if (x < 0 || y < 0 || x >= game.getMapSize() || y >= game.getMapSize()) {
            this.game.newRound();
            return;
        }

        game.setHeroCoordinates(x, y);

        if (game.checkForMonster()) {
            this.gameScreen.displayEncounter();
        }
        else{
            displayGame();
        }


    }

    public void displayGame() {
        this.gameScreen.display(this.game);
    }

    public Game getGame() {
        return this.game;
    }

    public void onFight() {
        Monster monster = this.game.randomMonster();
        this.gameScreen.displayMonster(monster);
        if (this.game.fight(monster) <= 0) {
            this.gameScreen.displayFightLost();
        } else {
            this.gameScreen.displayFightWon(monster);
        }
    }

    public void onRun() {
        Random random = new Random(System.nanoTime());
        if (random.nextInt(1) > 0){
            this.gameScreen.displayRunSuccess();
        }
        else{
            this.gameScreen.displayRunFailed();
        }
    }
}
