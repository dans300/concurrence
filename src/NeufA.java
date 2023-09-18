public class NeufA {


    String msn="debut";

    public static void main(String[] args) throws InterruptedException {
        NeufA hilos=new NeufA();
        Thread principal=Thread.currentThread();
        System.out.println(hilos.msn);


        Thread t1=new Thread(new Runnable() {
            @Override
            public void run()
            {
                int i=5;
                while(i<=25&&!Thread.currentThread().isInterrupted())
                {
                    System.out.print(i + " ");
                    i+=5;
                }

            }
        });


        Thread t2=new Thread(new Runnable() {
            @Override
            public void run()
            {
                int i=100;
                while (i<=500)
                {
                    System.out.print(i + " ");
                    i+=100;
                }

                /*if(t1.isAlive()==false)
                {
                    hilos.msn="FIN";
                    //t1.interrupt();

                }else
                {
                    hilos.msn="Deuxième thread s’est terminé en premier";
                }*/


            }
        });



        //t2.setPriority(Thread.MAX_PRIORITY);//selon la priorité ici l'un ou l'autre finit en premier
        //System.out.println(t1.getPriority()+" "+t2.getPriority()+" "+principal.getPriority());

        t1.start();
        t1.join();
        t2.start();




    }
}
