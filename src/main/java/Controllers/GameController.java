package Controllers;

import Models.Artifacts.Artifact;
import Models.Game;
import Models.Mobs.Monster;
import Models.SaveLoad;
import Views.Console.GameScreen;
import Views.GameView;

import java.util.Random;

import static Models.Artifacts.Artifact.*;

public class GameController {

    private GameView gameView;
    private int prevX;
    private int prevY;
    private Game game;

    public GameController(Game game, GameView gameView){
        this.gameView = gameView;
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

        if (x < 0 || y < 0 || x >= this.game.getMapSize() || y >= this.game.getMapSize()) {
            game.moveHero(x, y, prevX, prevY);
            this.game.newRound(); //Needs to be built
            displayGame();
        }
        else if (game.moveHero(x, y, prevX, prevY)) {
            this.gameView.displayEncounter();
        }
        else{
            game.setMap();
            displayGame();
        }


    }

    public void displayGame() {
        if (this.game.getRound() >= 2){
            gameView.displayWin();
        }
        else{
            this.gameView.display(this.game);
        }
    }

    public Game getGame() {
        return this.game;
    }

    public void onFight() {
        Monster monster = this.game.randomMonster();
        this.gameView.displayMonster(monster);
        if (this.game.fight(monster) <= 0) {
            this.gameView.displayFightLost();
        } else {
            game.setMap();
            this.gameView.displayFightWon(monster);
        }
    }

    public void onRun() {
        Random random = new Random(System.nanoTime());
        if (random.nextInt(2) > 0){
            game.setHeroCoordinates(prevX, prevY);
            game.setMap();
            this.gameView.displayRunSuccess();
        }
        else{
            this.gameView.displayRunFailed();
        }
    }

    public void onEquipLoot(Artifact[] equipped) {
        if (equipped[HELM] != null && equipped[HELM].getBuff() > 0)
            game.getHero().getEquipped()[HELM] = equipped[HELM];
        if (equipped[ARMOUR] != null && equipped[ARMOUR].getBuff() > 0)
            game.getHero().getEquipped()[ARMOUR] = equipped[ARMOUR];
        if (equipped[WEAPON] != null && equipped[WEAPON].getBuff() > 0)
            game.getHero().getEquipped()[WEAPON] = equipped[WEAPON];
    }

    public void onSave() {
        SaveLoad.saveGame(game.getHero());
    }

    public void onSwitch() {
        this.gameView.switchDisplay();
    }
}
