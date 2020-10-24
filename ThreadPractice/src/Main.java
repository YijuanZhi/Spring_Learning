import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        * This practice includes:
        *
        * 1. Runnable thread creation and Callable thread creation
        *
        * 2. Thread pool creation with 4 types of thread pools:
        *    a. singleThreadPool
        *    b. cachedThreadPool
        *    c. fixedThreadPool
        *    d. scheduledThreadPool
        *
        * 3. forkJoinPool
        *
        */

        
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





        //Callable interface + Thread pool example with fixed thread pool
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



        //Thread pool example 2 with fixed thread pool running Runnable tasks
        ExecutorService executor2 = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 200; ++i) {
            executor2.execute(new Task());
        }
        executor2.shutdown();
        System.out.println("Thread name: " + Thread.currentThread().getName());




        //Tread pool example 3 with cached thread pool running Runnable tasks
        ExecutorService executor3 = Executors.newCachedThreadPool();
        for(int i = 0; i < 100; ++i) {
            executor3.execute(new Task());
        }
        executor3.shutdown();



        //Thread pool example 4 with singled thread pool running callable tasks + Future<T>
        List<Future<Integer>> futureList2 = new ArrayList<>();
        ExecutorService executor4 = Executors.newSingleThreadExecutor();
        for(int i = 0; i < 10; ++i) {
            futureList2.add(executor4.submit(new Task2()));
        }
        for(Future<Integer> curFuture : futureList2) {
            try{
                // this will say the current thread is main,
                // because when we get the future from executor4.submit, it is been executed
                System.out.println(curFuture.get() + " and the Thread name is: " + Thread.currentThread().getName());
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        executor4.shutdown();


        //Thread pool example 5 with scheduled thread pool with can only run with Runnable tasks
        ScheduledExecutorService executor5 = Executors.newScheduledThreadPool(10);
        for(int i = 0; i < 10; ++i) {
            //perform tasks after a 10 seconds initial delay
            executor5.schedule(new Task(), 10, TimeUnit.SECONDS);

            //perform tasks after a 15 seconds initial delay, run tasks every 10s regardless how long the task will take
            executor5.scheduleAtFixedRate(new Task(), 15, 10, TimeUnit.SECONDS);

            //perform tasks after a 15s initial delay, run a task, only after the task is finished after 10s delay run another task
            executor5.scheduleWithFixedDelay(new Task(), 15, 10, TimeUnit.SECONDS);
        }
        executor5.shutdown();

    }

    //static inner class implementing Runnable interface
    static class Task implements Runnable{
        public void run(){
            System.out.println("Thread name: " + Thread.currentThread().getName());
        }
    }

    //static inner class implementing Callable interface
    static class Task2 implements Callable<Integer>{
        @Override
        public Integer call() throws Exception {
            return 0;
        }
    }
}
