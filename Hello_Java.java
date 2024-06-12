public class Hello_Java extends Thread{
    public void run(){
        for(int i = 0 ; i < 10 ; i++){
            System.out.println("Hello Java");
        }
    }
    public static void main(String[] args) {
        Hello_Java t1 = new Hello_Java();
    //    Hello_Java t2 = new Hello_Java();
        t1.start();
    //    t2.start();
    }
}
