package Views.Console;

import Controllers.GameController;
import GameLogic.Main;
import Models.Game;
import Models.Mobs.Monster;
import Views.GUI.GameScreenForm;

import java.util.Arrays;
import java.util.Scanner;

public class GameScreen implements Views.GameView {

    private GameController controller;

    public GameScreen(Game game){
        controller = new GameController(game, this);
    }

    @Override
    public void display(Game game) {
        System.out.println("----------Round "+game.getRound()+"----------");
        System.out.println(game.getHero().toString() +
                "\nClass: " + game.getHero().getClass().getSimpleName() +
                "\nPosition: " + "(" + game.getHeroX() +
                "," + game.getHeroY() + ")");
        System.out.println("---------------------------");

        Scanner scanner = Main.getScanner();
        System.out.println("Choose a command:");
        System.out.println("NORTH, EAST, SOUTH, WEST - to move to in the direction");
        System.out.println("SWITCH - to switch to GUI");
        System.out.println("MAP - to see map");
        System.out.println("SAVE - save your hero progress so far");
        System.out.println("EXIT - to exit game");

        while (scanner.hasNext()) {
            String input = scanner.nextLine();

            if ("north".equalsIgnoreCase(input) ||
                        "east".equalsIgnoreCase(input) ||
                        "south".equalsIgnoreCase(input) ||
                        "west".equalsIgnoreCase(input)) {
                controller.onMove(input);
                break;
            } else if ("switch".equalsIgnoreCase(input)) {
                controller.onSwitch();
                break;
            }else if ("map".equalsIgnoreCase(input)) {
                printMap();
            }else if ("save".equalsIgnoreCase(input)) {
                controller.onSave();
            }
            else if ("exit".equalsIgnoreCase(input)) {
                controller.onSave();
                System.exit(0);
            }
            else {
                System.out.println("Unknown command");
            }
        }
    }

    private void printMap() {
        int[][] map = controller.getGame().getMap();
        System.out.println(Arrays.deepToString(map).replace("], ", "]\n"));
    }

    @Override
    public void displayEncounter() {
        Scanner scanner = Main.getScanner();

        System.out.println();
        System.out.println("A Monster has appeared! What are you going to do, " + controller.getGame().getHero().getName() + "? :");
        System.out.println("FIGHT - to battle the monster");
        System.out.println("RUN - to try and run away");

        while (scanner.hasNext()) {
            String input = scanner.nextLine();

            if ("fight".equalsIgnoreCase(input)) {
                controller.onFight();
                break;
            } else if ("run".equalsIgnoreCase(input)) {
                controller.onRun();
                break;
            } else {
                System.out.println("Unknown command");
            }
        }
    }

    @Override
    public void displayMonster(Monster monster) {
        System.out.println();
        System.out.println("My name is " + monster.getName() + ". Fear me!");
    }

    @Override
    public void displayFightLost() {
        System.out.println("Better luck next time hero");
    }

    @Override
    public void displayFightWon(Monster monster) {
        System.out.println("Well done hero! You defeated the monster!");
        System.out.println("The monster dropped an Artifact \n" + monster.toStringEquipped() + ".\nWould you like to equip it?");
        Scanner scanner = Main.getScanner();
        System.out.println("Choose a command:");
        System.out.println("Y/N");

        while (scanner.hasNext()) {
            String input = scanner.nextLine();

            if ("y".equalsIgnoreCase(input)) {
                controller.onEquipLoot(monster.getEquipped());
                break;
            } else if ("n".equalsIgnoreCase(input)) {
                break;
            }
            else {
                System.out.println("Unknown command");
            }
        }
        controller.displayGame();
    }

    @Override
    public void displayRunSuccess() {
        System.out.println("Well done you ran away... You really think you are fit for this job?");
        controller.displayGame();
    }

    @Override
    public void displayRunFailed() {
        System.out.println("Oops... Seems like you tripped... Gotta fight the monster now.");
        controller.onFight();
    }

    @Override
    public void switchDisplay(){
        new GameScreenForm().display(Main.getGame());
    }

    @Override
    public void displayWin(){
        System.out.println("Well done you you've cleaned up the city! You are the ultimate hero");
    }

}
