import java.awt.*;
import java.awt.event.*;
public class Display_char_Textfield extends Frame implements Runnable , ActionListener {
    TextField t1;
    Thread t;
    Button b;
    String str="Shweta";
    int i;
    public Display_char_Textfield()
    {
        setLayout(null);
        t1 = new TextField();
        t = new Thread(this,"Assign2");
        b = new Button("Start");

        t1.setBounds(100,100,100,30);
        b.setBounds(100,140,100,30);
        add(t1);
        add(b);
        b.addActionListener(this);
        setSize(400,400);
        setVisible(true);
       
    }
    
    public void actionPerformed(ActionEvent ae){
        t.start();
    }
    public void run()
    {
        try {
            for(i = 0; i <= str.length() ; i++){
                Thread.sleep(1000);
                t1.setText(t1.getText()+" "+str.charAt(i));
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Display_char_Textfield();
    }
}
