package com.antra;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Main {

    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        //creating the future fork join task
        Fibonacci task = new Fibonacci(10);
        //Executes the given command at some time in the future. It might straightly start execution if idle
        forkJoinPool.execute(task);
        //Performs the given task(may have started earlier), returning its result upon completion.
        Integer result = forkJoinPool.invoke(task);

        System.out.println(result);
    }

    private static class Fibonacci extends RecursiveTask<Integer> {
        final int n;
        Fibonacci(int n){ this.n = n;}

        @Override
        public Integer compute() {
            System.out.println("Now executing Fibonacci(" + n + ")");
            if(n < 2) return n;
            Fibonacci f1 = new Fibonacci(n-1);
            Fibonacci f2 = new Fibonacci(n-2);
            f1.fork();
            f2.fork();
            return f1.join() + f2.join();
        }
    }
}
