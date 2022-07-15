package Exam.day15_7_12;

import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/07/15/10:17
 * @Description: 二进制中1的个数
 */
public class BinarySystem1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int count = 0;
            while (n != 0) {
                //消去x二进制数的最后一位1
                n = n & (n -1);
                //能消去就代表有一位1
                count++;
            }
            System.out.println(count);
        }
    }
}
