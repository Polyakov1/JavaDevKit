package org.example;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Philosopher extends Thread {
    private final String name;
    private final int leftFork;
    private final int rightFork;
    private int countEat;
    private final Random random;
    private final CountDownLatch cdl;
    private final Table table;

    public Philosopher(String name, Table table, int leftFork, int rightFork, CountDownLatch cdl)
    {
        this.table = table;
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.cdl = cdl;
        countEat = 0;
        random = new Random();
    }

    @Override
    public void run() {

        int needEat = 3;
        while (countEat < needEat) {
            try {
                thinking();

                eating();
            } catch (InterruptedException e) {
                e.fillInStackTrace();
            }
        }

        System.out.println(name + " наелся");
        cdl.countDown();
    }

    private void eating() throws InterruptedException {
        if (table.tryGetForks(leftFork, rightFork)) {
            System.out.println(name + " кушает, используя вилки: " + leftFork
                    + " и " + rightFork);
            sleep(random.nextLong(300, 600));
            table.putForks(leftFork, rightFork);
            System.out.println(name + " покушал, теперь подумаю. " +
                    "Не забыл убрать вилки " + leftFork + " и " + rightFork);
            countEat++;
        }

    }

    private void thinking() throws InterruptedException {
        sleep(random.nextLong(100, 2000));
    }
}