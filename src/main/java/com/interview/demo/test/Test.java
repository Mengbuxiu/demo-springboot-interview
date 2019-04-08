package com.interview.demo.test;



import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        JSONObject.fromObject("{\"level\":[\"3\"]}");
        //System.out.println(0/100);
        String url = "local:8080/license/status";
        int license = url.indexOf("/license/");
        System.out.println(url.substring(license));

        //Object -> Integer || Integer -> Object   都会报编译错误
//        List<Object> intList = new ArrayList<>(3);
//        intList.add(111);
//        List<?> objects = intList;
    }
//    @Test
//    public void maopao() {
//        boolean swapped;
//        int[] arr = new int[]{5, 2, 6, 7, 3};
//        do {
//             swapped = false;
//            for (int i = 0; i < arr.length - 1; i++) {
//                if (arr[i] < arr[i + 1]){
//                    int temp = arr[i];
//                    arr[i] = arr[i + 1];
//                    arr[i + 1] = temp;
//                    swapped = true;
//                }
//            }
//        }while (swapped);
//        for (int a:arr) {
//            System.out.print(a +" ");
//        }
//    }



}
