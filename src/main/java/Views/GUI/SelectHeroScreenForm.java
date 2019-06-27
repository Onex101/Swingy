package Views.GUI;

import Controllers.SelectHeroController;
import GameLogic.Main;
import Models.Mobs.Hero;
import Views.SelectHeroView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class SelectHeroScreenForm implements SelectHeroView {

    private SelectHeroController controller;
    private JPanel mainPanel;
    private JList list1;
    private JButton OKButton;

    public SelectHeroScreenForm() {
        controller = new SelectHeroController(this);
        final List<Hero> heroList = controller.getSaveGames();
        String[] heroNames = new String[heroList.size()];
        for(int i = 0; i < heroList.size(); i++) {
            heroNames[i] = heroList.get(i).getName();
        }
        list1.setListData(heroNames);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(list1.getSelectedIndex());
                controller.onHeroSelect(heroList.get(list1.getSelectedIndex()));
            }
        });
    }

    @Override
    public void display() {
        JFrame frame = Main.getFrame();
        frame.setContentPane(mainPanel);
        frame.pack();
    }

    @Override
    public void goToGame() {
        new GameScreenForm().display(Main.getGame());
    }

    @Override
    public void goToHeroCreate() {

    }
}
