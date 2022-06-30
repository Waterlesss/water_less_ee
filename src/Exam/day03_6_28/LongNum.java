package Exam.day03_6_28;

import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/06/30/11:51
 * @Description: 读入一个字符串str，输出字符串str中的连续最长的数字串
 */
public class LongNum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        StringBuffer sb1 = new StringBuffer();
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            //1.判断取出来的字符是不是数字
            if (str.charAt(i) >='0' && str.charAt(i) <= '9') {
                sb1.append(str.charAt(i));
            } else {
                //2.1说明此时字符不是数字
                //2.2判断结果集和取出来字符串的长度
                if (sb1.length() > res.length()) {
                    res = sb1.toString();
                }
                //2.3将取出来的字符置为空，防止下一次拼接的时候存在上一个结果集中的数字
                sb1.delete(0,sb1.length());
            }
        }
        //循环走完后在判断一下两个的长度
        //因为有字符串的最后全是数字的情况，这个时候就不会走到第二步
        if (sb1.length() > res.length()) {
            res = sb1.toString();
        }
        System.out.println(res) ;
    }
}
