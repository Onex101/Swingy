package Views.GUI;

import Controllers.CreateHeroController;
import GameLogic.Main;
import Views.CreateHeroView;

import javax.swing.*;
import java.awt.event.*;

public class CreateHeroScreenForm implements CreateHeroView {
    private JPanel mainPanel;
    private JTextField txtHeroName;
    private JButton continueButton;
    private JTextArea txtReadyBox;
    private JLabel lblChooseHeroClass;
    private JLabel lblHeroName;
    private JTable tblHeroChoices;
    private String value;
    private CreateHeroController controller;

    public CreateHeroScreenForm() {
        controller = new CreateHeroController(this);
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(value != null && !value.isEmpty() && txtHeroName.getText() != null && !txtHeroName.getText().isEmpty()){
                    controller.onCreateHero(txtHeroName.getText(), value);
                }
            }
        });

        tblHeroChoices.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                value = tblHeroChoices.getModel().getValueAt(tblHeroChoices.getSelectedRow(), 0).toString();

                txtReadyBox.setText("Welcome " + txtHeroName.getText() + ". You will be ranked "+ value +" Class. Defeat Monsters plaguing our cities to gain experience and lvl up.");
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

    private void createUIComponents() {
        String[] columnNames = {"Class", "Attack", "Defence", "Hit Points"};
        Object[][] data = {{"C", "10", "10", "10"},{"B", "15", "15", "15"},{"A", "20", "20", "20"},{"S", "30", "30", "30"}};
        tblHeroChoices = new JTable(data, columnNames);
    }
}
