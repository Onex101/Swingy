package Views.GUI;

import Controllers.GameController;
import GameLogic.Main;
import Models.Game;
import Models.Mobs.Hero;
import Models.Mobs.Monster;
import Views.Console.GameScreen;
import Views.GameView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class GameScreenForm extends JFrame implements GameView {

    private GameController controller;
    private JFrame frame;

    private JLabel lblGameTime;
    private JPanel mainPanel;
    private JLabel lblName;
    private JLabel lblHitPnts;
    private JLabel lblAttackPnts;
    private JLabel lblDefencePnts;
    private JLabel lblExperiencePnts;
    private JLabel lblStatHeader;
    private JLabel lblEquippedHeader;
    private JButton btNorth;
    private JButton btWest;
    private JButton btEast;
    private JButton btSouth;
    private JPanel pnlCentre;
    private JTextArea txtMap;
    private JPanel pnlEncounter;
    private JPanel pnlMonster;
    private JPanel pnlFightLost;
    private JPanel pnlFightWon;
    private JPanel pnlRunSuccess;
    private JPanel pnlRunFail;
    private JPanel pnlDirections;
    private JPanel pnlRunFight;
    private JPanel pnlContinue;
    private JButton btContinue;
    private JButton btFight;
    private JButton btRun;
    private JPanel pnlStats;
    private JPanel pnlEquiped;
    private JPanel pnlButtons;
    private JTextArea txtNotifiication;
    private JPanel pnlNotification;
    private JButton btYes;
    private JButton btNo;
    private JPanel pnlYesNo;
    private JButton saveButton;
    private JButton switchButton;
    private Monster monster;

    public GameScreenForm() {
        controller = new GameController(Main.getGame(),this);
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.onMove(e.getActionCommand());
            }
        };
        btNorth.addActionListener(listener);
        btWest.addActionListener(listener);
        btEast.addActionListener(listener);
        btSouth.addActionListener(listener);

        btRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.onRun();
            }
        });

        btFight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.onFight();
            }
        });

        btContinue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.onEquipLoot(monster.getEquipped());
                controller.displayGame();
            }
        });
        btNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.displayGame();
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.onSave();
            }
        });
        switchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.onSwitch();
            }
        });
    }

    @Override
    public void display(Game game) {
        Hero hero = game.getHero();
        lblName.setText("Name: " + hero.getName());
        lblHitPnts.setText("Hit Points: " + hero.getHitPnts());
        lblAttackPnts.setText("Attack Points: " + hero.getAttackPnts());
        lblDefencePnts.setText("Defence Points: " + hero.getDefencePnts());
        lblExperiencePnts.setText("Experience Points: " + hero.getExperiencePnts());
        hideAllCentrePanels();
        hideAllButtonPanels();
        pnlDirections.setVisible(true);
        printMap();
        JFrame frame = Main.getFrame();
        frame.setContentPane(mainPanel);
        frame.pack();
    }

    private void printMap() {
        int[][] map = controller.getGame().getMap();
       txtMap.setText(Arrays.deepToString(map).replace("], ", "]\n"));
    }


    @Override
    public void displayEncounter() {
        txtNotifiication.setText("A Monster has appeared! What are you going to do, " + controller.getGame().getHero().getName() + "? :");
        hideAllButtonPanels();
        pnlRunFight.setVisible(true);
    }

    @Override
    public void displayMonster(Monster monster) {
        this.monster = monster;
        txtNotifiication.setText("My name is " + monster.getName() + ". Fear me!\n");
        hideAllButtonPanels();
    }

    @Override
    public void displayFightLost() {
        txtNotifiication.append("Better luck next time hero");
    }

    @Override
    public void displayFightWon(Monster monster) {
        txtNotifiication.append("Well done hero! You defeated the monster!\n The monster dropped an Artifact \n" + monster.toStringEquipped() + "Would you like to equip it?");
        pnlYesNo.setVisible(true);
    }

    @Override
    public void displayRunSuccess() {
        txtNotifiication.setText("Well done you ran away!");
        hideAllButtonPanels();
        pnlDirections.setVisible(true);
    }

    @Override
    public void displayRunFailed() {
        txtNotifiication.setText("Oops... Seems like you tripped... Gotta fight the monster now.");
        hideAllButtonPanels();
        pnlContinue.setVisible(true);
        controller.onFight();
    }

    @Override
    public void switchDisplay(){
        Main.getFrame().setVisible(false);
        new GameScreen(Main.getGame());
    }

    @Override
    public void displayWin(){
        txtNotifiication.setText("Well done you you've cleaned up the city! You are the ultimate hero!");
        hideAllButtonPanels();
    }

    private void hideAllCentrePanels(){
       pnlEncounter.setVisible(false);
       pnlMonster.setVisible(false);
       pnlFightLost.setVisible(false);
       pnlFightWon.setVisible(false);
       pnlRunSuccess.setVisible(false);
       pnlRunFail.setVisible(false);
       pnlRunFight.setVisible(false);
       pnlContinue.setVisible(false);
    }

    private void hideAllButtonPanels(){
        pnlDirections.setVisible(false);
        pnlContinue.setVisible(false);
        pnlRunFight.setVisible(false);
        pnlYesNo.setVisible(false);
    }
}
