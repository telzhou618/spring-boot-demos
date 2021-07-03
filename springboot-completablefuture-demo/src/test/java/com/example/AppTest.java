package com.example;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jameszhou
 */
public class AppTest {

    private static AtomicInteger ATOMIC_INTEGER = new AtomicInteger(1);

    private static final Executor EXECUTOR = new ThreadPoolExecutor(
            5,
            5,
            0,
            TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(100),
            r -> new Thread("thread-pool-completableFuture-" + ATOMIC_INTEGER.getAndDecrement()),
            new ThreadPoolExecutor.AbortPolicy()
    );

    @Test
    public void test() throws InterruptedException {

        EXECUTOR.execute(() -> {
            System.out.println("hahahh");
        });

        TimeUnit.SECONDS.sleep(100);

    }
}
