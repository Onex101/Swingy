package Views.Console;

import Controllers.CreateHeroController;
import GameLogic.Main;
import Models.Mobs.Hero;

import java.util.Scanner;

public class CreateHeroScreen {
    private CreateHeroController controller;

    public void Display() {
        controller = new CreateHeroController();
        Scanner scanner = Main.getScanner();

        System.out.println("Welcome to the Hero Association. Please sign up by giving us your Hero Name");
        System.out.println("Enter name:");
        String name = scanner.nextLine();

        System.out.println("Hero Classes:\n" +
                "Class      atk     def     hp\n" +
                "C          10      10      10\n" +
                "B          15      15      15\n" +
                "A          20      20      20\n" +
                "S          30      30      30\n");
        System.out.println("Choose a class:\n");
        String heroClass = scanner.nextLine();

        System.out.println("Welcome " + name + ". You will be ranked "+heroClass+" Class. Defeat Monsters plaguing our cities to gain experience and lvl up.");
        System.out.println("Are you ready? Y/N");

        while (scanner.hasNext()) {
            String input = scanner.nextLine();

            if ("y".equalsIgnoreCase(input)) {
                System.out.println("Get out there!");
                controller.onCreateHero(name, heroClass);
                break;
            } else {
                System.out.println("Then why do you want to be a Hero?");
                //exit program or go back to home screen;
                break;
            }
        }
    }


}
