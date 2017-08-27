package org.leIngeneursInc.problems.forFun;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Thread safe implementation Fibonacci
 */
public class MultiThreadedFibonacci {
    private int[] arr;
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public MultiThreadedFibonacci() {
        initializeUpto(2);
    }

    public MultiThreadedFibonacci(int n) {
        n = n < 2 ? 2 : n;
        initializeUpto(n);
    }

    private void initializeUpto(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input can not be negative. Input Value: " + n);
        }

        if (arr != null && n < arr.length) {
            return;
        }
        readWriteLock.writeLock().lock();
        arr = new int[n + 1];
        arr[0] = 0;
        if (n > 0) {
            arr[1] = 1;
        }

        for (int idx = 2; idx <= n; idx++) {
            arr[idx] = arr[idx - 1] + arr[idx - 2];
        }

        readWriteLock.writeLock().unlock();
    }

    public int get(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input can not be negative. Input Value: " + n);
        }

        if (n >= arr.length) {
            initializeUpto(n);
        }
        readWriteLock.readLock().lock();
        int val = arr[n];
        readWriteLock.readLock().unlock();
        return val;
    }


    public static void main(String[] args) {
        final int[] fib = fib(45);
        final MultiThreadedFibonacci multiThreadedFibonacci = new MultiThreadedFibonacci();

        final int THREAD_COUNT = 100;
        final CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int idx = 0; idx < THREAD_COUNT; idx++) {
            threads[idx] = new Thread(() -> {
                countDownLatch.countDown();
                int randIdx = new Random().nextInt(46);
                Assert.assertTrue(multiThreadedFibonacci.get(randIdx) == fib[randIdx]);
            });
        }
        for (Thread t : threads) {
            t.start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("DONE");

    }


    private static int[] fib(int n) {
        if (n < 2) {
            return new int[]{0, 1};
        }

        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int idx = 2; idx <= n; idx++) {
            arr[idx] = arr[idx - 1] + arr[idx - 2];
        }
        return arr;
    }
}