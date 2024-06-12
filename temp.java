class Mythread extends Thread{
	public void run(){
		for(int i = 1; i <= 3; i++){
		System.out.println(Thread.currentThread().threadId() +" Value "+ i);
		Thread.yield();
		}
	}
} 
public class temp{
	public  static void main(String args[]){
		Mythread t1 = new Mythread();
		Mythread t2 = new Mythread();
        Mythread t3 = new Mythread();
		t1.start();
		t2.start();
        t3.start();
	}
}