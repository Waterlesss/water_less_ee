package Exam.day06_7_01;

/**
 * @Author: Waterless
 * @Date: 2022/07/03/22:54
 * @Description: 把字符串转换成整数
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为 0 或者字符串不是一个合法的数值则返回 0
 */
public class StrToNum {
    public int StrToInt(String str) {
        //如果字符串非法，直接返回0
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int sum = 0;
        //定义标志位，判断第一个出现的是不是 + 或者 -
        boolean sign = false;
        char[] arr = str.toCharArray();
        if (arr[0] == '-') {
            sign = true;
            arr[0] = '0';
        }
        if (arr[0] == '+') {
            sign = false;
            arr[0] = '0';
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < '0' || arr[i] > '9') {
                return 0;
            }
            //字符’1到9‘通过 - '0' 就可以转换为整数，类似于 字母B - ’A‘
            sum = sum *10 + arr[i] - '0';
        }
        if (sign) {
            sum = -sum;
        }
        return sum;
    }
}
