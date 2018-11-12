package geometry;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class QuadCanvas extends JPanel {
    private ArrayList<Quad> quads = new ArrayList<Quad>();
    private Thread run;

    public void add(Quad q) {
        this.quads.add(q);
    }

    public ArrayList<Quad> getQuads(){
        return quads;
    }

    public Thread getRun() {
        return run;
    }

    public void setRun(Thread run) {
        this.run = run;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < quads.size(); i++) {
            Quad q = quads.get(i);
            q.draw(g2);
        }
    }
}
