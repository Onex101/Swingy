package GameLogic;

import Controllers.GameController;
import Models.Game;
import Views.Console.GameScreen;
import Views.Console.MenuScreen;
import Views.GUI.GameScreenForm;
import Views.GUI.MenuScreenForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
        oframe.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                if (oGame.getHero() != null){
                    new GameController(oGame, new GameScreen(oGame)).onSave();
                }
                System.exit(0);
            }
        });
		oframe.setVisible(true);
		oframe.setPreferredSize(new Dimension(1000,800));

		if (args.length > 0 && args[0].equals("gui")){
			MenuScreenForm menuScreenForm = new MenuScreenForm();
			menuScreenForm.display();
		}
		else{
			MenuScreen mainMenu = new MenuScreen();
			mainMenu.display();
		}
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
