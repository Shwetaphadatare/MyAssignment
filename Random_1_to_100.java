import java.util.Random;
public class Random_1_to_100 extends Thread {
    public void run()
    {
        try {
            Random r = new Random();
        for(int i = 0; i < 100 ; i++){
            int num = r.nextInt(100) + 1;
            System.out.println(num + "  ");
            Thread.sleep(2000);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public static void main(String[] args) {
        Random_1_to_100 t = new Random_1_to_100();
        t.start();
    }
}
