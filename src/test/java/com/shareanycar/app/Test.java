package com.shareanycar.app;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.lang.System.getProperty;
import static java.lang.System.setProperty;

/**
 * Created by slava on 14/10/2017.
 */
public class Test {

    @org.junit.Test
    public void test() {
        long p = 2140010033;

        final long[] sum = {0};

        setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "8");
        long start = System.currentTimeMillis();
        sum[0] = LongStream.range(0, p).parallel().reduce(0,(x,y)->x+y);

        System.out.println((System.currentTimeMillis() - start) / 1000.0);
        System.out.println(sum[0]);

        long ss = 0;
        start = System.currentTimeMillis();
        for (long x = 0; x < p; x++) {
            ss += x;
        }
        System.out.println((System.currentTimeMillis() - start) / 1000.0);
        System.out.println(ss);

        start = System.currentTimeMillis();
        ss = p*(p-1)/2;
        System.out.println((System.currentTimeMillis() - start) / 1000.0);
        System.out.println(ss);
    }


}
