package task2;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.Path2D;

    public class Star
    {
        private static final int SCREEN_WIDTH = 600;
        private static final int SCREEN_HEIGHT = 600;


        public static void main(String[] args)
        {
            drawingAndDisplay();
        }

        private static void drawingAndDisplay()
        {
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            StarPanel starPanel = new StarPanel();
            f.getContentPane().add(starPanel);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(Color.lightGray);

            JLabel labelQuantity = new JLabel("coordinates: ");
            JTextField textFieldX = new JTextField("200",4);
            JTextField textFieldY = new JTextField("200",4);

            JLabel labelRadius = new JLabel("Radius: ");
            JTextField textFieldRadius = new JTextField("600",4);

            JButton buttonStart = new JButton("Draw");

            buttonStart.addActionListener(e -> {
                int x = Integer.parseInt(textFieldX.getText());
                int y = Integer.parseInt(textFieldY.getText());
                int r = Integer.parseInt(textFieldRadius.getText());

                starPanel.setParameters(x, y, r);
                f.repaint();
            });

            buttonPanel.add(labelQuantity);
            buttonPanel.add(textFieldX);
            buttonPanel.add(textFieldY);
            buttonPanel.add(labelRadius);
            buttonPanel.add(textFieldRadius);
            buttonPanel.add(buttonStart);

            f.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

            f.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        }

    }

    class StarPanel extends JPanel {
        private int x;
        private int y;
        private int radius;

        public void setParameters(int x, int y, int r){
            this.x = x;
            this.radius = r;
            this.y = y;
        }

        @Override
        protected void paintComponent(Graphics gr) {
            super.paintComponent(gr);
            Graphics2D g = (Graphics2D) gr;

            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g.draw(drawStar(x, y, radius));
        }


        private static Shape drawStar(double koordX, double koordY, int radius) {
            Path2D p = new Path2D.Double();

            Double innerRadius = radius/2.63;
            final int numRays = 5;
            final Double startAngleR = Math.toRadians(-18);
            double deltaAngleR = Math.PI / numRays;

            for (int i = 0; i < numRays * 2; i++) {
                double angleR = startAngleR + i * deltaAngleR;
                double ca = Math.cos(angleR);
                double sa = Math.sin(angleR);
                double relX = ca;
                double relY = sa;
                if ((i & 1) == 0) {
                    relX *= innerRadius * 2.63;
                    relY *= innerRadius * 2.63;
                } else {
                    relX *= innerRadius;
                    relY *= innerRadius;
                }
                if (i == 0) {
                    p.moveTo(koordX + relX, koordY + relY);
                } else {
                    p.lineTo(koordX + relX, koordY + relY);
                }
            }
            p.closePath();
            return p;
        }
    }

