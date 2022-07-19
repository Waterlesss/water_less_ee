package Exam.day19_7_17;

import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/07/19/20:34
 * @Description: 汽水瓶
 * 某商店规定：三个空汽水瓶可以换一瓶汽水，允许向老板借空汽水瓶（但是必须要归还）。
 * 小张手上有n个空汽水瓶，她想知道自己最多可以喝到多少瓶汽水。
 */
public class Bottle {
    public static void  main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int count = 0;
            while (n > 1) {
                count = count + n / 3;//兑换汽水的个数
                n = n / 3 + n % 3; //剩余的空瓶子
                if (n == 2) {
                    count += 1;
                    break;
                }
            }
            if (count != 0) {
                System.out.println(count);
            }
        }
    }
}
