package Exam.day04_06_29;

import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/07/01/17:21
 * @Description: 进制转换
 * 给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
 */
public class DecimalConversion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt(), n = scan.nextInt();
        StringBuilder sb = new StringBuilder();
        //2-16进制
        String table = "0123456789ABCDEF";
        //记录m是否为负数
        boolean flag = false;
        if (m == 0) System.out.println(0);
        if (m < 0) {
            m = -m;
            flag = true;
        }
        while (m != 0) {
            //几进制就模几 在除几
            //数学计算中是一直除几 然后取余，读数时倒着读
            //通过索引在对应的table中取字符
            sb.append(table.charAt(m % n));
            m = m / n;
        }
        //m是负数，需要拼接-号
        if (flag == true) sb.append("-");
        //拼接完后逆置
        sb.reverse();
        System.out.println(sb);
    }
}
