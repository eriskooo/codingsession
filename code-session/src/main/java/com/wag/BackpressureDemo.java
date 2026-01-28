package com.wag;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BackpressureDemo {

    public static void main(String[] args) throws Exception {
        BlockingQueue<Integer> q = new ArrayBlockingQueue<>(3); // MALÁ kapacita => rýchlo uvidíš backpressure

        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    Integer x = q.take();
                    System.out.println(ts() + " CONSUME " + x + "  (queueSize=" + q.size() + ")");
                    Thread.sleep(700); // zámerne pomalý consumer
                }
            } catch (InterruptedException ignored) {
            }
        }, "consumer");

        Thread producer = new Thread(() -> {
            int i = 0;
            try {
                while (true) {
                    System.out.println(ts() + " PRODUCE " + i + " -> put() ...");
                    q.put(i); // keď je queue plná, TENTO THREAD SA ZABLOKUJE = backpressure
                    System.out.println(ts() + " PRODUCE " + i + " -> put() DONE (queueSize=" + q.size() + ")");
                    i++;
                    Thread.sleep(100); // producer je oveľa rýchlejší
                }
            } catch (InterruptedException ignored) {
            }
        }, "producer");

        consumer.start();
        producer.start();

        Thread.sleep(10_000);
        producer.interrupt();
        consumer.interrupt();
    }

    private static String ts() {
        return String.format("[%1$tT.%1$tL]", System.currentTimeMillis());
    }
}
