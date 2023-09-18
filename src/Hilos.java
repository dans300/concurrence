import java.util.concurrent.CountDownLatch;

public class Hilos {


    String msn="debut";

    public static void main(String[] args) throws InterruptedException {
        Hilos hilos=new Hilos();
        Thread principal=Thread.currentThread();
        System.out.println(hilos.msn);


        Thread t1=new Thread(new Runnable() {
            @Override
            public void run()
            {
                int i=1;
                while (i<=50&&!Thread.currentThread().isInterrupted())
                {
                    System.out.println(i + " FROM A");
                    i++;
                }
                //hilos.msn="FIN";
                //Thread.currentThread().interrupt();
            }
        });


        Thread t2=new Thread(new Runnable() {
            @Override
            public void run()
            {
                int i=1;
                while (i>=-50)
                {
                    System.out.println(i + " FROM B");
                    i--;
                }

                if(t1.isAlive()==false)
                {
                    hilos.msn="FIN";
                    //t1.interrupt();

                }else
                {
                    hilos.msn="Deuxième thread s’est terminé en premier";

                }


            }
        });
        //el daemon tiene la mas minima prioridad!!!

        /*Thread demon =new Thread(new Runnable() {
            @Override
            public void run()
            {
                while (true) {
                   //System.out.println("this is a demon");
                }
            }
            });
        demon.setDaemon(true);
        demon.start();*/

        //t2.setPriority(Thread.MAX_PRIORITY);//selon la priorité ici l'un ou l'autre finit en premier
        System.out.println(t1.getPriority()+" "+t2.getPriority()+" "+principal.getPriority());

        t2.start();
        //t2.join();//punto 4 hasta que no acabe t2 no empieza t1
        //System.out.println(" phrase simple ");
        t1.start();



        t2.join();
        t1.join();
       //principal.sleep(5800);
        System.out.println(hilos.msn);



    }
}
