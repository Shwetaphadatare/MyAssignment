import javax.swing.*;
import java.awt.event.*;

public class Blink_image extends JFrame implements ActionListener,Runnable{
    Thread t1;
    JLabel l1;
    JButton b1;
    boolean b;
    public Blink_image(){
        b =  true;
        setLayout(null);
        ImageIcon img = new ImageIcon("C:\\Users\\shewt\\Pictures\\demo.jpg");
        l1 = new JLabel(img);
        t1 = new Thread(this,"DYP");
        b1 = new JButton("Blink");
        l1.setBounds(100,100,100,100);
        b1.setBounds(100,210,100,30);
        add(l1);
        add(b1);
        setSize(400,400);
        setVisible(true);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        t1.start();
    }
    public void run()
    {
        try {
            while(true){
                Thread.sleep(500);
                if(b==true){
                    l1.setVisible(true);
                    b = false;
                }
                else{
                    l1.setVisible(false);
                    b = true;
                }            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Blink_image();
    }
}