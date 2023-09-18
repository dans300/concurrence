import java.util.ArrayList;
import java.util.List;

public class EX3 extends  Thread{

int a=5;
int b=3;
int cuantas=2;


    public synchronized int calculadora(char q) throws InterruptedException {

        int res = 0;
        while (cuantas == 0)
        {
            //System.out.println(q + " me dormi");
            wait();
        }
        if (cuantas>0)
        {
            cuantas -= 1;
            System.out.println("una calculadora  en uso  por        " + q);
            //wait(2000);

            switch (q) {
                case 'a':
                    res = a + b;
                case 'b':
                    res = a * 2;
                case 'c':
                    res = b + (b ^ 2) - a;
                case 'd':
                    a = a - 1;
                    res = a;

                case 'e':
                    res = (a + b) + (a * 2) + (b + (b ^ 2) - a);
            }
            cuantas += 1;
            notifyAll();
            return res;
        }
return 0;


    }
    int i=0;
    public static void main(String[] args) throws InterruptedException {

                EX3 p=new EX3();
        System.out.println("a="+p.a + " b="+p.b);
        sleep(1500);

        Thread uno=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                while(p.i<30) {
                    System.out.println("uno a+b=" + p.calculadora('a'));
                    p.i+=1;
                }
                    } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread dos=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (p.i<30) {
                        //sleep(2000);
                        System.out.println("dos a*2=" + p.calculadora('b'));p.i+=1;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread tres=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (p.i<30) {
                        //sleep(2000);
                        System.out.println("tres b+b²-a=" + p.calculadora('c'));
                        p.i+=1;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread cuatro=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (p.i<30) {
                        //System.out.println("cuatro gonna update a hold on everybody ");
                        //sleep(2000);
                        System.out.println("cuatro update a=" + p.calculadora('d'));
                        p.i+=1;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread cinco=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (p.i<30) {

                        //sleep(2000);
                        System.out.println("cinco uno+dos+tres=" + p.calculadora('e'));
p.i+=1;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });



        uno.start();
        dos.start();
        tres.start();
        cuatro.start();
        cinco.start();
        uno.join();
        dos.join();
        tres.join();
        cuatro.join();
        cinco.join();
        //sleep(300);
    }

}
