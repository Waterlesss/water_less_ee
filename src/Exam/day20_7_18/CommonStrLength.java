package Exam.day20_7_18;

import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/07/21/16:44
 * @Description: 最大公共子串的长度
 * 给定两个只包含小写字母的字符串，计算两个字符串的最大公共子串的长度。
 * 输入两个只包含小写字母的字符串
 *输出一个整数，代表最大公共子串的长
 * 注：子串的定义指一个字符串删掉其部分前缀和后缀（也可以不删）后形成的字符串。
 */
public class CommonStrLength {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        System.out.println(maxComLength(str1,str2));

    }
    //动态规划的思想去做
    public static int maxComLength(String str1, String str2) {
        int maxLength = 0;
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                    }
                }
            }
        }
        return maxLength;
    }
}
