package Views.GUI;

import Controllers.MenuController;
import Controllers.SelectHeroController;
import GameLogic.Main;
import Models.Mobs.Hero;
import Views.MenuView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static Models.SaveLoad.getSaveGames;

public class MenuScreenForm implements MenuView {
    private JButton newGameButton;
    private JButton loadGameButton;
    private JPanel mainPanel;
    private MenuController controller;

    public MenuScreenForm() {
        controller = new MenuController(this);
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.onCreateHero();
            }
        });
        loadGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getSaveGames().size() > 0){
                    controller.onSelectHero();
                }
            }
        });
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.onCreateHero();
            }
        });
    }

    public void display(){
        JFrame frame = Main.getFrame();
        frame.setContentPane(mainPanel);
        frame.pack();
    }

    public void goToHeroSelect(){
        new SelectHeroScreenForm().display();
    }

    public void goToHeroCreate(){
        new CreateHeroScreenForm().display();
    }

}
