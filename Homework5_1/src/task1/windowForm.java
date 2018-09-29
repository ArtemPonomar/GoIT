package task1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class windowForm extends JFrame {

    private Canvas canvas;
    public static final int WIDTH = 720;
    public static final int HEIGHT = 720;

    public windowForm() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Draw snowman");

        this.canvas = new Canvas();

        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);

        JLabel labelQuantity = new JLabel("Quantity: ");
        JTextField textFieldQuantity = new JTextField("3",4);

        JLabel labelMinWidth = new JLabel("Min width: ");
        JTextField textFieldMinWidth = new JTextField("60",4);

        JLabel labelMaxWidth = new JLabel("Max width: ");
        JTextField textFieldMaxWidth = new JTextField("200",4);

        JButton buttonStart = new JButton("Draw");

        JButton buttonRed = new JButton("Paint red");

        buttonStart.addActionListener(e -> {
            int test = canvas.getWidth();
            canvas.clear();

            Painter painter = new Painter(canvas.getWidth(),
                    Integer.parseInt(textFieldQuantity.getText()),
                    Integer.parseInt(textFieldMinWidth.getText()),
                    Integer.parseInt(textFieldMaxWidth.getText())
            );

            painter.drawFace();
            painter.drawBody();

            canvas.addAll(painter.getCircles());
            canvas.repaint();
        });

        buttonRed.addActionListener(e -> {
            ArrayList<Circle> redSnowman = Painter.repaint(canvas.getCircles(), Color.RED);
            canvas.clear();
            canvas.addAll(redSnowman);
            canvas.repaint();
        });

        buttonPanel.add(labelQuantity);
        buttonPanel.add(textFieldQuantity);
        buttonPanel.add(labelMinWidth);
        buttonPanel.add(textFieldMinWidth);
        buttonPanel.add(labelMaxWidth);
        buttonPanel.add(textFieldMaxWidth);
        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonRed);


        content.add(buttonPanel, BorderLayout.SOUTH);
    }
}
