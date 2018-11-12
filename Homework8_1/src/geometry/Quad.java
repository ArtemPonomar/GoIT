package geometry;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Quad {
    private Component canvas;
    private int X_SIZE;
    private int Y_SIZE;
    private int x;
    private int y;
    private int dx = 2;
    private int dy = 2;
    private Color color;
    private Boolean alive;

    public Quad(Component c){
        Random random = new Random();

        this.canvas = c;
        this.X_SIZE = 30 + random.nextInt(60);
        this.Y_SIZE = 30 + random.nextInt(60);
        this.x = random.nextInt(600);
        this.y = random.nextInt(600);
        this.color = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
        this.alive = true;
    }

    public Boolean isAlive() {
        return alive;
    }

    public void kill(){
        this.alive = false;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fill(new Rectangle(x, y, X_SIZE, Y_SIZE));
    }

    public void move() {
        x += dx;
        y += dy;
        if (x < 0) {
            x = 0;
            dx = -dx;
        }
        if (x + X_SIZE >= this.canvas.getWidth()) {
            x = this.canvas.getWidth() - X_SIZE;
            dx = -dx;
        }
        if (y < 0) {
            y = 0;
            dy = -dy;
        }
        if (y + Y_SIZE >= this.canvas.getHeight()) {
            y = this.canvas.getHeight() - Y_SIZE;
            dy = -dy;
        }
        this.canvas.repaint();
    }

}
