package com.java_feature.tenum.entity;

/**
 * 颜色
 * @author Administrator
 */
public enum Color {

    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLOW("黄色", 4);

    private String name;
    private int index;

    Color(String name, int index) {
        this.name = name;
        this.index = index;
    }


    public static String getName(int index) {
        for (Color c : Color.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}  