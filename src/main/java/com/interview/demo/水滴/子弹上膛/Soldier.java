package com.interview.demo.水滴.子弹上膛;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 士兵
 */
public class Soldier {
    /**
     * 弹夹实体
     */
    private static final LinkedList<Bullet> CLIP = new LinkedList<>();

    public Soldier(int size) {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                CLIP.add(new Bullet());
            }
        }

    }

    public void shootBullet(long mills) throws InterruptedException {
        synchronized (CLIP) {
            if (mills < 0) {
                while (CLIP.isEmpty()) {
                    CLIP.wait();
                }
                // 正常来说此处应直接返回,不用走判断,只是为了打印效果
            } else {
                final long timeout = System.currentTimeMillis() + mills;
                long remain = mills;

                while (CLIP.isEmpty() && remain > 0) {
                    CLIP.wait();
                    remain = timeout - System.currentTimeMillis();
                    System.out.println("----------弹夹内没有子弹------------");
                }
                System.out.println(" 是否获取到子弹：" + !CLIP.isEmpty());
            }
            if (!CLIP.isEmpty()) {
                final Bullet bullet = CLIP.removeFirst();
                System.out.println("peng!" + bullet.fly());
            }

        }
    }

    public void pushBullet(Bullet bullet) {
        if (bullet != null) {
            synchronized (CLIP) {
                CLIP.addLast(bullet);
                System.out.println("\t子弹上膛");
                CLIP.notifyAll();
            }
        }
    }

    public static class Bullet {
        public Bullet() {
            System.out.println("当前弹夹内子弹数：" + (CLIP.size() + 1));
            System.out.println("\t 压入一颗子弹");
        }

        public String fly() {
            return "\n\t~~~~~~~~~~~~~~~~~";
        }
    }
}
