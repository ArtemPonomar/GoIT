package task1;

import java.awt.*;
import java.util.ArrayList;

public class Painter {
    //static final int MIN_SIZE = 2;

    private ArrayList<Circle> circles = new ArrayList<>();

    private int quantity;
    private int minSize;
    private int maxSize;

    private int screenWidth;
    private int currentY = 50;

    public Painter(int screenWidth, int quantity, int minSize, int maxSize) {
        this.screenWidth = screenWidth;
        this.quantity = quantity;
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

    public void drawFace() {

        Circle head = new Circle(minSize, maxSize);
        double r = head.getSize() / 2; //radius of generated circle

        head.setX((int) (screenWidth / 2 - r));
        head.setY(currentY);
        currentY += head.getSize();

        circles.add(head);

        Circle leftEye = new Circle((int) r / 4, (int) r / 2);
        double delta = r - r / (2 * Math.sqrt(2));
        int x1 = head.getX() + (int) delta;
        int y1 = head.getY() + (int) delta;
        leftEye.setX(x1 - leftEye.getSize()/2);
        leftEye.setY(y1 - leftEye.getSize()/2);

        circles.add(leftEye);

        Circle rightEye = new Circle((int) r / 4, (int) r / 2);
        int x2 = head.getX() + (int) delta + (int)delta;
        int y2 = y1;
        rightEye.setX(x2 - rightEye.getSize()/2);
        rightEye.setY(y2 - rightEye.getSize()/2);

        circles.add(rightEye);

        Circle mouth = new Circle((int) r / 4, (int) r / 2);
        int x3 = head.getX() + (int)r;
        int y3 = head.getY() + 3 * (int)r / 2;
        mouth.setX(x3 - mouth.getSize()/2);
        mouth.setY(y3 - mouth.getSize()/2);

        circles.add(mouth);
    }

    public void drawBody() {
        for (int i = 1; i < quantity; i ++){
            Circle bodyPart = new Circle(minSize, maxSize);
            int x = screenWidth/2 - bodyPart.getSize()/2;
            int y = currentY;

            bodyPart.setX(x);
            bodyPart.setY(y);
            currentY += bodyPart.getSize();

            circles.add(bodyPart);
        }
    }

    public static ArrayList<Circle> repaint(ArrayList<Circle> circlesToRepaint, Color newColor){
        ArrayList<Circle> result = new ArrayList<>();
        for (Circle circle : circlesToRepaint) {
            circle.setColor(newColor);
            result.add(circle);
        }
        return result;
    }

    public ArrayList<Circle> getCircles() {
        return circles;
    }
}
