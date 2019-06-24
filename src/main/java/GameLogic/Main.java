package GameLogic;

import Models.Game;
import Views.Console.MenuScreen;

import java.util.Scanner;

public class Main {

	private static Scanner	oScanner;
	private static Game 	oGame;

	public static void main(String[] args) {

		oScanner = new Scanner(System.in);
		oGame = new Game();
		System.out.println("Starting");

//		ApplicationControls.createWindow();
//
//		EventParsing.instructionParseAsync();
//
//		EventData.readStdinAsync();

		MenuScreen mainMenu = new MenuScreen();
		mainMenu.Display();

		System.out.println("End of main");

	}

	public static Scanner getScanner() {
		return oScanner;
	}

	public static Game getGame() {
		return oGame;
	}
}
