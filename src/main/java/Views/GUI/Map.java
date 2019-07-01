package Views.GUI;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    private static final int PANEL_W = 1000;
    private static final int PANEL_H = 900;

    public Map() {
        setBorder(BorderFactory.createLineBorder(Color.BLUE));
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        } else {
            return new Dimension(PANEL_W, PANEL_H);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // don't forget to call the super's method
        g.setColor(new Color(204, 204, 204));
        g.drawLine(0, 900, 1000, 900);
        g.drawLine(0, 800, 1000, 800);
        g.drawLine(0, 700, 1000, 700);
        g.drawLine(0, 600, 1000, 600);
        g.drawLine(0, 400, 1000, 400);
        g.drawLine(0, 300, 1000, 300);
        g.drawLine(0, 200, 1000, 200);
        g.drawLine(0, 100, 1000, 100);
        g.drawLine(100, 0, 100, 1000);
        g.drawLine(200, 0, 200, 1000);
        g.drawLine(300, 0, 300, 1000);
        g.drawLine(400, 0, 400, 1000);
        g.drawLine(600, 0, 600, 1000);
        g.drawLine(700, 0, 700, 1000);
        g.drawLine(800, 0, 800, 1000);
        g.drawLine(900, 0, 900, 1000);
        g.setColor(Color.BLACK);
        g.drawRect(0, 500, 1000, 1);
        g.drawRect(500, 0, 1, 1000);
    }
}
