package Exam.day11_7_07;

import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/07/09/20:38
 * @Description: 最大连续比特数
 * 求一个int类型数字对应的二进制数字中1的最大连续数，
 * 例如3的二进制为00000011，最大连续2个1
 */
public class MaxContinueBitNum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count = 0;
        int res = 0;
        while (n != 0) {
            if (n % 2 == 1) {
                count++;
                if (res < count) {
                    res = count;
                }
            } else {
                count = 0;
            }
            n = n / 2;
        }
        System.out.print(res);
    }
}
