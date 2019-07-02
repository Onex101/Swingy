package Views.GUI;

import Controllers.SelectHeroController;
import GameLogic.Main;
import Models.Mobs.Hero;
import Views.SelectHeroView;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class SelectHeroScreenForm implements SelectHeroView {

    private SelectHeroController controller;
    private JPanel mainPanel;
    private JList list1;
    private JButton OKButton;
    private JLabel lblHP;
    private JLabel lblATK;
    private JLabel lblDEF;
    private List<Hero> heroList;

    public SelectHeroScreenForm() {
        controller = new SelectHeroController(this);
        heroList = controller.getSaveGames();
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
        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Hero hero = heroList.get(list1.getSelectedIndex());
                lblHP.setText("HP: " + hero.getHitPnts());
                lblATK.setText("ATK: " + hero.getAttackPnts());
                lblDEF.setText("DEF: " + hero.getDefencePnts());
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
