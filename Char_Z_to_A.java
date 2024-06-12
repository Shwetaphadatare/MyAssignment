public class Char_Z_to_A extends Thread{
    public void run()
    {
        try {
            for(char c = 'Z' ; c >= 'A' ; c--){
                System.out.print(c + "  ");
                Thread.sleep(5000);
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
    public static void main(String[] args) {
        Char_Z_to_A thread = new Char_Z_to_A();
        thread.start();
    }
}
