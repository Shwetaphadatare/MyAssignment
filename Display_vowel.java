import java.util.*;
public class Display_vowel extends Thread {
    public void run(){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter String : ");
            String str = sc.nextLine();
            for(int i = 0 ; i < str.length() ; i++){
                if(str.charAt(i)=='a' ||str.charAt(i)=='e' ||str.charAt(i)=='i' ||str.charAt(i)=='o' ||str.charAt(i)=='u' ||str.charAt(i)=='A' ||str.charAt(i)=='E' ||str.charAt(i)=='I'|| str.charAt(i)=='O' ||str.charAt(i)=='U' ){
                    System.out.println(str.charAt(i));
                    Thread.sleep(3000);
                }
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Display_vowel t = new Display_vowel();
        t.start();
    }
}
