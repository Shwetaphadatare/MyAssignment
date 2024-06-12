import java.util.*;
public class Sum_average_10  implements Runnable{
    Thread t;
    int i,no,sum;
    int a[] = new int[1000];
    String tn = " ";
    Sum_average_10(String s,int n){
        tn = s;
        Random rs = new Random();
        t = new Thread(this,s);
        no = n;
        int j = 0;
        for(i = 1; i <= 1000; i++){
            a[j] = rs.nextInt(1000);
            j++;
        }
        t.start();
    }
    public void run()
    {
        for (int i = 0; i < 100; i++) {
            sum = sum + a[no];
            no++;            
        }
        System.out.println("Name of thread is : "+tn);
        System.out.println("Sum : "+sum);
        System.out.println("Average : "+ sum/100);
    }
    public static void main(String[] args) throws InterruptedException {
        int n = 0;
        String tname[] = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};
        Sum_average_10 T[] = new Sum_average_10[10];
        for (int i = 0; i < 10; i++) {
            T[i] = new Sum_average_10(tname[i], n);
            n = n + 100;
            T[i].t.join();
        }
    }
    
}
