package Offer;

/**
 * @Author: Waterless
 * @Date: 2022/07/12/23:12
 * @Description: 二进制数中1的个数
 */
public class Num15 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            //消去x的最后一位1
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
