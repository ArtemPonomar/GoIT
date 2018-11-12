package geometry;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class BounceFrame extends JFrame {

    private QuadCanvas canvas;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;

    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce program");

        this.canvas = new QuadCanvas();
        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);

        JButton multiThread = new JButton("Multi thread");

        JButton singleThread = new JButton("Single thread");

        multiThread.addActionListener(e -> {
            while (canvas.getQuads().size() != 0){
                canvas.getQuads().get(0).kill();
                canvas.getQuads().remove(0);
            }

            for (int i = 0; i < 3 + new Random().nextInt(7); i++){
                Quad q = new Quad(canvas);
                new QuadThread(q).start();
                canvas.add(q);
            }
        });

        singleThread.addActionListener(e -> {
            canvas.getQuads().clear();
            if (canvas.getRun()!= null) {
                canvas.getRun().interrupt();
            }

            for (int i = 0; i < 3 + new Random().nextInt(7); i++){
                canvas.add(new Quad(canvas));
            }

            canvas.setRun(new QuadsThread(canvas));
            canvas.getRun().start();
        });

        buttonPanel.add(multiThread);
        buttonPanel.add(singleThread);

        content.add(buttonPanel, BorderLayout.SOUTH);
    }
}
