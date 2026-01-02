package com.wag;

import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Kju {

    static LinkedBlockingQueue<String> kju = new LinkedBlockingQueue();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    System.out.print(">");
                    String s = scanner.nextLine();
                    kju.offer(s);
                    if ("exit".equalsIgnoreCase(s)) {
                        break;
                    }
                }
            }
        });
        t1.setDaemon(true);
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String taken = kju.take();
                        System.out.println(taken);
                        if ("exit".equalsIgnoreCase(taken)) {
                            break;
                        }
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        t2.start();
    }
}
