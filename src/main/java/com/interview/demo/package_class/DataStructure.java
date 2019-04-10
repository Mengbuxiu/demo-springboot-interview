package com.interview.demo.package_class;

public class DataStructure {

    //创建一个数组
    private final static int SIZE = 15;
    private int[] arrayOfInts = new int[SIZE];

    public DataStructure() {
        //用升序整数值填充数组
        for (int i = 0; i < SIZE; i++) {
            arrayOfInts[i] = i;
        }
    }

    public void printEven() {

        //打印出数组偶数索引的值
        DataStructureIterator iterator = this.new EvenIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "");
        }
        System.out.println();
    }

    interface DataStructureIterator extends java.util.Iterator<Integer> {
    }

    //内部类实现DataStructureIterator接口，
    //扩展了Iterator <Integer>接口

    private class EvenIterator implements DataStructureIterator {

        //从头开始单步执行数组
        private int nextIndex = 0;

        public boolean hasNext() {

            //检查当前元素是否是数组中的最后一个元素
            return (nextIndex <= SIZE - 1);
        }

        public Integer next() {

            //记录数组的偶数索引的值
            Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);

            //获取下一个偶数元素
            nextIndex += 2;
            return retValue;
        }
    }

    public static void main(String s[]) {

        //使用整数值填充数组并仅打印输出
        //偶数索引的值
        DataStructure ds = new DataStructure();
        ds.printEven();
    }
}
