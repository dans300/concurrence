public class Ex2Q2 {

    public static void main(String args[]){
        Table2 obj = new Table2();//only one object
        MyThread3 t3=new MyThread3(obj);
        MyThread4 t4=new MyThread4(obj);
        t3.start();
        t4.start();
    }
}

class Table2{
    synchronized void  printTable2(int n) throws InterruptedException{
        for(int i=1;i<=6;i++){
            System.out.println(n*i);
            if(i%3==0) {
                System.out.println();
                wait();
            }
            notifyAll();
            try{
                //Thread.sleep(400);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
}

class MyThread3 extends Thread{
    Table2 t;
    MyThread3(Table2 t){
        this.t=t;
    }
    public void run(){
        try {
            t.printTable2(5);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
class MyThread4 extends Thread{
    Table2 t;
    MyThread4(Table2 t){
        this.t=t;
    }
    public void run(){
        try {
            t.printTable2(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

