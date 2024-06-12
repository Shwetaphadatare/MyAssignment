import java.awt.*;
import java.awt.Graphics;
import javax.swing.*;

public class Draw_5_lines extends JPanel {

    int x1,x2,y1,y2;
  
    public Draw_5_lines() {
        x1 = 10;
        x2 = 10;
        y1 = 50;
        y2 = 400;
    }
   
    public void paintComponent(Graphics g) {
        Thread thread = new Thread(){
           public void run(){
                try{
                    Thread.sleep(1000);
                    for(int i = 0; i < 5 ; i++){
                        super.paintComponent(g);
                        g.setColor(Color.BLUE);
                        x1 += 50;
                        x2 += 50;
                        g.drawLine((int) (x1), (int) (y1), (int)(x2), (int)y2);
                    }
                }
                catch(Exception e){

                }    
            }
        };
    }

  public static void main(String[] args) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("Draw lines");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 600);
    new Draw_5_lines();
    frame.setVisible(true);
  }
}