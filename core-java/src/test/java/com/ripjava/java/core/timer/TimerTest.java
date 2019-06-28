package com.ripjava.java.core.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

public class TimerTest {
    @Test
    public void testTimer_SchedulingTaskOnce() throws Exception {
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("Task performed on: " + new Date() + "n" +
                        "Thread's name: " + Thread.currentThread().getName());
            }
        };
        Timer timer = new Timer("Timer");
        long delay = 1000L;
        timer.schedule(task, delay);
        Thread.sleep(delay * 2);
    }

    @Test
    public void testTimer_SchedulingRepeatedTask() throws InterruptedException {
        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                System.out.println("Task performed on " + new Date());
            }
        };
        Timer timer = new Timer("Timer");

        long delay = 1000L;
        long period = 1000L;
        timer.scheduleAtFixedRate(repeatedTask, delay, period);
        Thread.sleep(delay * 10);
    }

    @Test
    public void testTimer_SchedulingDailyTask() {
        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                System.out.println("Task performed on " + new Date());
            }
        };
        Timer timer = new Timer("Timer");

        long delay = 1000L;
        long period = 1000L * 60L * 60L * 24L;
        timer.scheduleAtFixedRate(repeatedTask, delay, period);
    }

    @Test
    public void testTimer_CancelingTimerTask()
            throws InterruptedException {
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("Task performed on " + new Date());
                cancel();
            }
        };
        Timer timer = new Timer("Timer");

        timer.scheduleAtFixedRate(task, 1000L, 1000L);

        Thread.sleep(1000L * 10);
    }

    @Test
    public void testTimer_CancelingTimer()
            throws InterruptedException {
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("Task performed on " + new Date());
            }
        };
        Timer timer = new Timer("Timer");

        timer.scheduleAtFixedRate(task, 1000L, 1000L);
        Thread.sleep(1000L * 1);
        timer.cancel();
        Thread.sleep(1000L * 9);
    }

    @Test
    public void testTimer_StoppingThread()
            throws InterruptedException {
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("Task performed on " + new Date());
                // TODO: 假如在这里停止
                Thread.currentThread().stop();
            }
        };
        Timer timer = new Timer("Timer");

        timer.scheduleAtFixedRate(task, 1000L, 1000L);

        Thread.sleep(1000L * 10);
    }

    @Test
    public void testTimer_SchedulingRepeatedTask_ByScheduledExecutorService() throws InterruptedException{
        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                System.out.println("Task performed on " + new Date());
            }
        };
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        long delay = 1000L;
        long period = 1000L;
        executor.scheduleAtFixedRate(repeatedTask, delay, period, TimeUnit.MILLISECONDS);
        Thread.sleep(delay + period * 3);
        executor.shutdown();
    }
}
