package Views.GUI;

import GameLogic.Main;
import Models.Game;
import Models.Mobs.Monster;
import Views.GameView;

import javax.swing.*;

public class GameScreenForm implements GameView {

    private JLabel label1;
    private JPanel mainPanel;

    @Override
    public void display(Game game) {
        JFrame frame = Main.getFrame();
        frame.setContentPane(mainPanel);
        frame.pack();
    }

    @Override
    public void displayEncounter() {

    }

    @Override
    public void displayMonster(Monster monster) {

    }

    @Override
    public void displayFightLost() {

    }

    @Override
    public void displayFightWon(Monster monster) {

    }

    @Override
    public void displayRunSuccess() {

    }

    @Override
    public void displayRunFailed() {

    }
}
