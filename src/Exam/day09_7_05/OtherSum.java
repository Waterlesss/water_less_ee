package Exam.day09_7_05;

/**
 * @Author: Waterless
 * @Date: 2022/07/07/15:45
 * @Description: 不使用数学运算符 求两数之和
 */
public class OtherSum {
    public int addAB(int A, int B) {
        if (B == 0) return A;
        int sum = 0;
        int tmp = 0;
        while (B != 0) {
            //二进制数 异或的结果是两个数对应位相加的结果(不考虑进位).
            //二进制数 相与后 左移一位的结果是两数相加进位后的结果(考虑进位).
            sum = A ^ B;
            tmp = (A & B) << 1;
            if (tmp == 0) return sum;
            A = sum;
            B = tmp;
        }
        return A;
    }
}
