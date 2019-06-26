package Views.Console;

import Controllers.MenuController;
import GameLogic.Main;

import java.util.Scanner;

public class MenuScreen implements Views.MenuView {

    private MenuController controller;

    @Override
    public void Display() {
        controller = new MenuController();
        System.out.println("Welcome to One Punch Man RPG");

        Scanner oScanner = Main.getScanner();
        System.out.println("Choose a Command to begin:");
        System.out.println();
        System.out.println("CREATE - to create a new hero");
        System.out.println("SELECT - to select a previously created hero");
        while (oScanner.hasNext()) {
            String input = oScanner.nextLine();

            if ("create".equalsIgnoreCase(input)) {
                controller.onCreateHero();
                break;
            } else if ("select".equalsIgnoreCase(input)) {
                controller.onSelectHero();
                break;
            } else {
                System.out.println("Unknown command");
            }
        }
    }

//Need to switch view
//Need to add select Hero
}