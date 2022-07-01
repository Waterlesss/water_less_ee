package Exam.day04_06_29;

import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/07/01/16:49
 * @Description: 计算糖果
 * A, B, C三个人是好朋友, 每个人手里都有一些糖果, 我们不知道他们每个人手上具体有多少个糖果,
 * 但是我们知道以下的信息：
 * A - B, B - C, A + B, B + C. 这四个数值.每个字母代表每个人所拥有的糖果数.
 * 现在需要通过这四个数值计算出每个人手里有多少个糖果,即A,B,C。
 * 这里保证最多只有一组整数A,B,C满足所有题设条件。
 */
public class Candy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = scan.nextInt(),
                num2 = scan.nextInt(),
                num3 = scan.nextInt(),
                num4 = scan.nextInt();
        int A = (num1 + num3) >> 1;
        int B1 = (num3 - num1) >> 1;
        int B2 = (num2 + num4) >> 1;
        int C = (num4 - num2) >> 1;
        if (B1 != B2) System.out.println("No");
        else System.out.println(A + " " + B1 + " " + C);
    }
}
