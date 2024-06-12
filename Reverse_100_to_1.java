public class Reverse_100_to_1 extends Thread{
    public void run(){
        try {
            for(int i = 100 ; i > 0 ; i--){
                Thread.sleep(6000);
                System.out.println(i);
            }
            
        } catch (Exception e) {
           e.printStackTrace();
        }
       
    }
    public static void main(String[] args) {
        Reverse_100_to_1 t1 = new Reverse_100_to_1();
        
        t1.start();
        System.out.println("Thread name is : "+ t1.getName());
        t1.setName("MyThread");
        System.out.println("New name of thread : " + t1.getName());


    }
}
