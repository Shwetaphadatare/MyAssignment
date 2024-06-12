import java.awt.*;
import javax.swing.*;

public class Bouncing_3_balls extends JPanel {

  // Box height and width
  int width;
  int height;

  // Ball Size
  float radius = 40;
  float diameter = radius * 2;

  // Ball 1
  float x1 = radius + 50;
  float y1 = radius + 20;
  //float dx1 = 3;
  float dy1 = 7;

  // Ball 2
  float x2 = radius + 150;
  float y2 = radius + 20;
 // float dx2 = 5;
  float dy2 = 7;

  // Ball 3
  float x3 = radius + 250;
  float y3 = radius + 20;
 // float dx3 = 7;
  float dy3 = 7;

  public Bouncing_3_balls() {

    Thread thread = new Thread() {
      public void run() {
        while (true) {

          width = getWidth();
          height = getHeight();

          // Ball 1
        //  x1 = x1 + dx1;
          y1 = y1 + dy1;

        //   if (x1 - radius < 0) {
        //     dx1 = -dx1;
        //     x1 = radius;
        //   } else if (x1 + radius > width) {
        //     dx1 = -dx1;
        //     x1 = width - radius;
        //   }

          if (y1 - radius < 0) {
            dy1 = -dy1;
            y1 = radius;
          } else if (y1 + radius > height) {
            dy1 = -dy1;
            y1 = height - radius;
          }

          // Ball 2
         // x2 = x2 + dx2;
          y2 = y2 + dy2;

        //   if (x2 - radius < 0) {
        //     dx2 = -dx2;
        //     x2 = radius;
        //   } else if (x2 + radius > width) {
        //     dx2 = -dx2;
        //     x2 = width - radius;
        //   }

          if (y2 - radius < 0) {
            dy2 = -dy2;
            y2 = radius;
          } else if (y2 + radius > height) {
            dy2 = -dy2;
            y2 = height - radius;
          }

          // Ball 3
        //  x3 = x3 + dx3;
          y3 = y3 + dy3;

        //   if (x3 - radius < 0) {
        //     dx3 = -dx3;
        //     x3 = radius;
        //   } else if (x3 + radius > width) {
        //     dx3 = -dx3;
        //     x3 = width - radius;
        //   }

          if (y3 - radius < 0) {
            dy3 = -dy3;
            y3 = radius;
          } else if (y3 + radius > height) {
            dy3 = -dy3;
            y3 = height - radius;
          }

          repaint();

          try {
            Thread.sleep(50);
          } catch (InterruptedException ex) {
            ex.printStackTrace();
          }

        }
      }
    };
    thread.start();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.BLUE);
    g.fillOval((int) (x1 - radius), (int) (y1 - radius), (int) diameter, (int) diameter);
    g.setColor(Color.RED);
    g.fillOval((int) (x2 - radius), (int) (y2 - radius), (int) diameter, (int) diameter);
    g.setColor(Color.GREEN);
    g.fillOval((int) (x3 - radius), (int) (y3 - radius), (int) diameter, (int) diameter);
  }

  public static void main(String[] args) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("Bouncing Balls");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 600);
    frame.setContentPane(new Bouncing_3_balls());
    frame.setVisible(true);
  }
}