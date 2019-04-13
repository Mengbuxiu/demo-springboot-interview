package com.java_feature.tenum;

import com.java_feature.tenum.entity.Color;

/**
 * @author Administrator
 * @desc //TODO
 * @date 2019/4/13
 */
public class TestColor {
    private final static Enum[] colors = {Color.BLANK,Color.GREEN,Color.RED,Color.YELLOW};
    public static void main(String[] args) {
        for (Enum color : colors) {
            System.out.println("color.ordinal()+\" -:-\"+ color.name() = " + color.ordinal() + " -:-" + color.name());
        }
    }
}
