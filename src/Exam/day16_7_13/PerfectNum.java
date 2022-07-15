package Exam.day16_7_13;

import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/07/15/20:23
 * @Description: 完全数
 * 完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
 * 它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
 * 例如：28，它有约数1、2、4、7、14、28，除去它本身28外，
 * 其余5个数相加，1+2+4+7+14=28。
 * 输入n，请输出n以内(含n)完全数的个数。
 */
public class PerfectNum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        //统计完全数的个数
        int count = 0;
        //从i开始一直到n 判断当前i是不是完全数
        for (int i = 1; i < n; i++) {
            //每次循环 都要sum置为0，重新计算
            int sum = 0;
            for (int j = 1; j < i ; j++) {
                //i能被j到n的某个数整除
                if (i % j == 0) {
                    //求和
                    sum += j;
                }
            }
            //判断等不等于当前i
            if (sum == i) {
                //等于就说明是一个完全数 次数加一
                count++;
            }
        }
        System.out.println(count);
    }
}
