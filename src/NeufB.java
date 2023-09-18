public class NeufB {

    public static volatile boolean able=true;


    String msn="debut";
    public boolean busy=false;

    public synchronized void unmetodo(int veces,int limit)
    {

        int i=1;

        while (i * veces <= limit)
        {
            if (i % 3 == 0)
            {
                System.out.print(i * veces + " ");
                try
                {
                    System.out.println("");
                    notifyAll();
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else
            {

                System.out.print(i * veces + " ");

            }
            i += 1;


        }

    }


    public static void main(String[] args) throws InterruptedException {
        NeufA hilos=new NeufA();
        Thread principal=Thread.currentThread();
        System.out.println(hilos.msn);
        NeufB b=new NeufB();


        Thread t1=new Thread(new Runnable() {
            @Override
            public synchronized void run()
            {
               b.unmetodo(5,30);
            }
        });


        Thread t2=new Thread(new Runnable() {
            @Override
            public synchronized void run()
            {
               b.unmetodo(100,600);
          }});

//se hace con modulo 3 igual a cero con wair y notifyall

        //t2.setPriority(Thread.MAX_PRIORITY);//selon la priorité ici l'un ou l'autre finit en premier
        //System.out.println(t1.getPriority()+" "+t2.getPriority()+" "+principal.getPriority());

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        }




}
