package Exam.day12_7_08;

/**
 * @Author: Waterless
 * @Date: 2022/07/11/15:49
 * @Description: 二进制插入
 * 给定两个32位整数n和m，同时给定i和j，将m的二进制数位插入到n的二进制的第j到第i位,
 * 保证n的第j到第i位均为零，且m的二进制位数小于等于i-j+1，
 * 其中二进制的位数从0开始由低到高。
 */
public class BinInsert {
    public int binInsert(int n, int m, int j, int i) {
        // write code here
        m = m << j;
        return m | n;
    }
}
