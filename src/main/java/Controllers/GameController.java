package Controllers;

import Models.Artifacts.Artifact;
import Models.Game;
import Models.Mobs.Monster;
import Views.Console.GameScreen;

import java.util.Random;

import static Models.Artifacts.Artifact.*;

public class GameController {

    private GameScreen gameScreen;
    private int prevX;
    private int prevY;
    private Game game;

    public GameController(Game game, GameScreen gameScreen){
        this.gameScreen = gameScreen;
        this.game = game;
    }

    public void onMove(String direction) {
        int x = game.getHeroX();
        int y = game.getHeroY();
        prevX = x;
        prevY = y;

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
            this.game.newRound(); //Needs to be built
            displayGame();
        }

        if (game.moveHero(x, y, prevX, prevY)) {
            this.gameScreen.displayEncounter();
        }
        else{
            game.setMap();
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
            game.setMap();
            this.gameScreen.displayFightWon(monster);
        }
    }

    public void onRun() {
        Random random = new Random(System.nanoTime());
        if (random.nextInt(2) > 0){
            game.setHeroCoordinates(prevX, prevY);
            game.setMap();
            this.gameScreen.displayRunSuccess();
        }
        else{
            this.gameScreen.displayRunFailed();
            this.onFight();
        }
    }

    public void onEquipLoot(Artifact[] equipped) {
        if (equipped[HELM] != null)
            game.getHero().getEquipped()[HELM] = equipped[HELM];
        if (equipped[ARMOUR] != null)
            game.getHero().getEquipped()[ARMOUR] = equipped[ARMOUR];
        if (equipped[WEAPON] != null)
            game.getHero().getEquipped()[WEAPON] = equipped[WEAPON];
    }
}
