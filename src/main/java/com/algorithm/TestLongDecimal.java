package com.algorithm;

/**
 * @author Alin
 * @version 1.0
 * @description // 循环实现除法计算小数精确到超长长度
 * @date 2019/8/17 10:35
 * 思路：
 * 1.直接计算出整数商，取余数。
 * 2.循环置顶次数{ 用余数/被除数 结果打印一下，在取余数；在余数/被除数 结果打印一下......[循环 ]    }
 */
public class TestLongDecimal {
    public static void main(String[] args) throws InterruptedException {
        double aNum = 182936;//被除数
        double bNum = 2763;//除数
        int number = 3000;//保留小数数量
        // 整数计算
        int cNum = (int) (aNum / bNum);
        // 循环计算小数部分
        String result = String.valueOf(cNum);//整数部分
        double dNum = aNum - bNum * cNum;//计算整数计算余数
        System.out.print("结果: " + result + ".");
        //开始计算
        double wNum1 = dNum;//余数
        int wNum2 = 0;//商
        int cs = 0;//循环次数
        while (true) {
            wNum1 *= 10;//余数*10
            wNum2 = (int) (wNum1 / bNum);//取商
            System.out.print(wNum2);//打印结果
            wNum1 = wNum1 % bNum;//取余数
            cs++;
            if (cs >= number) {
                break;
            }
            //延时
			/*try{
				Thread.sleep(1);
			}catch (InterruptedException e){
				e.printStackTrace();
			}*/
        }
        System.out.println("\n完成");
    }
}
