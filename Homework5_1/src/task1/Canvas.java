package task1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Canvas extends JPanel {
    private ArrayList<Circle> circles = new ArrayList<>();

    public void addAll(ArrayList<Circle> b) {
        this.circles.addAll(b);
    }
    public void clear(){ circles.clear(); }
    public ArrayList<Circle> getCircles(){ return circles; }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (int i = 0; i < circles.size(); i++) {
            Circle c = circles.get(i);
            c.draw(g2);
        }
    }
}
