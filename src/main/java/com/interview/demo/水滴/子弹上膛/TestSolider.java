package com.interview.demo.水滴.子弹上膛;

public class TestSolider {
    static Soldier soldier = new Soldier(20);
    static int shootCount = 1020;
    static int pushCount = 1000;

    private static class ShootWorker implements Runnable {
        @Override
        public void run() {
            while (shootCount > 0) {
                try {
                    soldier.shootBullet(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    shootCount--;
                }
            }
        }
    }

    private static class PushWorker implements Runnable {
        @Override
        public void run() {
            while (pushCount > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                soldier.pushBullet(new Soldier.Bullet());
                pushCount--;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ShootWorker()).start();
        new Thread(new PushWorker()).start();
        Thread.sleep(10000);
    }
}
