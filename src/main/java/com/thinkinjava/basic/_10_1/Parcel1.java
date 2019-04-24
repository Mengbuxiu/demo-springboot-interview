package com.thinkinjava.basic._10_1;


/**
 * @author Administrator
 * @desc //创建内部类。
 * @date 2019/4/23
 */
public class Parcel1 {
    class Contents{
        private int i = 11;
        public int value(){ return i; }
    }
    class Destination{
        private String label;
        Destination(String whereTo) {
            label = whereTo;
        }
        String readLabel() { return label; }
    }
    public void ship(String dest){
        Contents c = new Contents();
        System.out.println(c.value());
        Destination d = new Destination(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        Parcel1 p = new Parcel1();
        p.ship("beijing");
    }
}
