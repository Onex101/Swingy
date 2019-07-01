package GameLogic;

import Models.Game;
import Views.Console.MenuScreen;
import Views.GUI.MenuScreenForm;

import javax.swing.*;
import java.util.Scanner;

public class Main {

	private static Scanner	oScanner;
	private static Game 	oGame;
	private static JFrame	oframe;

	public static void main(String[] args) {

		oScanner = new Scanner(System.in);
		oGame = new Game();
		System.out.println("Starting");

		oframe = new JFrame("Swingy");
		oframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		oframe.setVisible(true);

//		ApplicationControls.createWindow();
//
//		EventParsing.instructionParseAsync();
//
//		EventData.readStdinAsync();


		//Uncomment later just testing GUI
//		MenuScreen mainMenu = new MenuScreen();
//		mainMenu.display();

		MenuScreenForm menuScreenForm = new MenuScreenForm();
		menuScreenForm.display();

		System.out.println("End of main");

	}

	public static Scanner getScanner() {
		return oScanner;
	}

	public static Game getGame() {
		return oGame;
	}

	public static JFrame getFrame() {
		return oframe;
	}

	public static void showFrame() {
		if (oframe != null)
			oframe.setVisible(true);
	}

	public static void hideFrame() {
		if (oframe != null)
			oframe.setVisible(false);
	}
}
