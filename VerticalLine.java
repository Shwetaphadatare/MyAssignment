import java.awt.*;
import javax.swing.*;
class VerticalLine extends JPanel implements Runnable {
    private int x;

    public VerticalLine(int x) {
        this.x = x;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(x, 100, x,500);
        x += 50;
       
        g.drawLine(x, 100, x,500);
        x += 50; 
        g.drawLine(x, 100, x,500);
        x += 50;
        g.drawLine(x, 100, x,500);
        x += 50;
        g.drawLine(x, 100, x,500);

    }

     @Override
    public void run() {
        while (true) {
          repaint();
            try {
                Thread.sleep(1000); // Adjust the sleep time as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("Draw lines");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 600);
    frame.setContentPane(new VerticalLine(100));
    frame.setVisible(true);
    }
}