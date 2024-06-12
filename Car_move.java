import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Car_move extends JFrame {
    private int car1X = 50; // Initial x-coordinate of the first car
    private int car2X = 100; // Initial x-coordinate of the second car

    public Car_move() {
        setTitle("Moving Two Cars Multithreaded");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CarPanel carPanel = new CarPanel();
        add(carPanel);

        Timer timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car1X += 5; // Move first car to the right
                car2X += 5; // Move second car to the right

                if (car1X > getWidth()) {
                    car1X = -50; // Reset first car to the left when it goes beyond the window width
                }

                if (car2X > getWidth()) {
                    car2X = -50; // Reset second car to the left when it goes beyond the window width
                }

                carPanel.repaint();
            }
        });
        timer.start();

        Thread car1Thread = new Thread(new CarRunnable(car1X));
        Thread car2Thread = new Thread(new CarRunnable(car2X));

        car1Thread.start();
        car2Thread.start();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Car_move().setVisible(true);
            }
        });
    }

    class CarPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawCar(g, car1X, 50);
            drawCar(g, car2X, 100);
        }

        private void drawCar(Graphics g, int x, int y) {
            g.setColor(Color.BLUE);
            g.fillRect(x, y, 50, 30); // Car body
            g.setColor(Color.RED);
            g.fillRect(x + 10, y - 20, 30, 20); // Car roof
            g.setColor(Color.BLACK);
            g.fillOval(x + 5, y + 25, 10, 10); // Left wheel
            g.fillOval(x + 35, y + 25, 10, 10); // Right wheel
        }
    }

    class CarRunnable implements Runnable {
        private int initialX;

        public CarRunnable(int initialX) {
            this.initialX = initialX;
        }

        @Override
        public void run() {
            int currentX = initialX;
            while (true) {
                currentX += 5; // Move car to the right
                if (currentX > getWidth()) {
                    currentX = -50; // Reset car to the left when it goes beyond the window width
                }
                repaint();
                try {
                    Thread.sleep(20); // Delay to control the speed of movement
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}