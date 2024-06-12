public class Hello_GM_SrMam  extends Thread{
    String text;
    int times;
    public Hello_GM_SrMam(String text,int times){
        this.text = text;
        this.times = times;
    }
  //  @Override
    public void run()
    {
        try{
            Thread.sleep(1000);
            for(int i = 0; i < times; i++){
                System.out.println(text);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
   

    public static void main(String args[]){
        Hello_GM_SrMam t1 = new Hello_GM_SrMam("Hello",10);
        Hello_GM_SrMam t2 = new Hello_GM_SrMam("Good Morning",20);
        Hello_GM_SrMam t3 = new Hello_GM_SrMam("Sir/Mam",30);
        t1.start();
        t2.start();
        t3.start();
    }
}