package Threading;

public class ThreadExample {
    public static  class Printer{
        synchronized void print(String name){
            for(int i=0;i<10;i++){
                System.out.println("printing document "+name+i+".docx");
            }

        }

    }

    static class mythread extends   Thread{
        Printer pref;

        mythread(Printer pref){
            this.pref=pref;
        }

        @Override
        public void run() {
          pref.print("machine learning thesis");
        }

    }


    static class yourthread extends   Thread{
        Printer pref;

        yourthread(Printer pref){
            this.pref=pref;
        }

        @Override
        public void run() {
            pref.print("stat thesis");
        }

    }

    public static class A{

    }


    public static void main(String[] args) {
        System.out.println("thread= "+Thread.currentThread().getName());
        System.out.println("application started");

       Printer printer=new Printer();
       mythread t=new mythread(printer);
       yourthread y=new yourthread(printer);
       t.start();
//       try {
//           t.join();
//       }
//       catch (Exception ee){ee.printStackTrace();}

       y.start();


        for(int i=0;i<10;i++){
            System.out.println("processing doc"+i+".docx");
        }


        System.out.println("application end");
    }
}
