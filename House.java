import java.awt.*;

public class House extends Frame{
    public House()
    {
        setTitle("Simple House");
        setSize(300,300);
        setVisible(true);
    }
    public void paint(Graphics g){
        //draw house
        g.drawRect(50, 100, 200, 150);
        //draw roof
        int[] xpoints = {50,150,250};
        int[] ypoints = {100,50,100};
        g.drawPolygon(xpoints, ypoints, 3);
        //draw door
        g.drawRect(120, 150, 60, 100);
        //draw window
        g.drawRect(60, 150, 50, 50);
        g.drawRect(190, 150, 50, 50);

    }
    public static void main(String[] args) {
        new House();
    }
}
