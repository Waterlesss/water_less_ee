package Offer;

/**
 * @Author: Waterless
 * @Date: 2022/07/12/23:37
 * @Description: 不用加减乘除做加法
 */
public class Num65 {
    public int add(int a, int b) {
        //位运算 两数相加时若不需要进位 直接异或
        //若需要进位 则需要进行 与 运算并左移 1 位
        while (b != 0) {
            int c = (a & b) << 1;
            a = a ^ b;
            b = c;
        }
        return a;
    }
}
