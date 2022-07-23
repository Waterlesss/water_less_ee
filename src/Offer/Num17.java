package Offer;

/**
 * @Author: Waterless
 * @Date: 2022/07/23/17:11
 * @Description: 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999
 */
public class Num17 {
    public int[] printNumbers(int n) {
        //求n的最大n位数 即10的n次方-1 
        int ans = (int)myPow(10,n) -1;
        int[] arr = new int[ans];
        for (int i = 0; i < ans; i++) {
            arr[i] = i+1;
        }
        return arr;
    }
    public static int myPow(int num,int n) {
        int res = 1;
        while (n != 0) {
            if ((n & 1) != 0) {
                res *= num;
            }
            num *= num;
            n >>= 1;
        }
        return  res;
    }
}
