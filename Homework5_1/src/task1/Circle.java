package task1;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle {

    private int x;
    private int y;

    private int size;

    private Color color;

    public Circle(int minSize, int maxSize){
        this.size = Randomizer.getRandNumberInRange(minSize, maxSize);
        this.color = Randomizer.getRandColour();
    }

    public void setX(int x){
        this.x = x;
    }
    public int getX() { return x; }

    public void setY(int y){
        this.y = y;
    }
    public int getY() { return y; }

    public int getSize(){
        return size;
    }
    public void setColor(Color color) { this.color = color; }

    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.draw(new Ellipse2D.Double(x, y, size, size));
    }
}
