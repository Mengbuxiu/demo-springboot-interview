package com.interview.demo.switch_and_if;

import java.util.Scanner;

public class TestSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        switch (next) {
            case "a":
            default:
                System.out.println(next);
                break;
            case "b":
                System.out.println(next);
                break;
        }
    }
}
