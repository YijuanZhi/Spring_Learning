import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        //Runnable interface example
        Runnable runnable1 = ()->{System.out.println("This is coming from the runnable thread 1!");};
        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(()->{System.out.println("This is coming from the runnable thread 2!");});
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                System.out.println("This is coming from the runnable thread 3!");
            }
        });
        t1.start();
        t2.start();
        t3.start();

        //Example class extending Thread class
        ThreadClassEx01 t4 = new ThreadClassEx01();
        t4.start();

        //Callable interface example
        Callable callable1 = ()->{return 0;};
        FutureTask<Integer> ft = new FutureTask<Integer>(callable1);
        Thread t5 = new Thread(ft);
        t5.start();
        System.out.println(ft.get());



         */
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<Integer>> futureList = new ArrayList<>();
        Callable<Integer>callable = ()->{return 0;};
        for(int i = 0; i < 20; i++){
            Future<Integer> curFuture = executor.submit(callable);
            futureList.add(curFuture);
        }
        for(Future<Integer> future : futureList){
            try{
                System.out.println(future.get());
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
