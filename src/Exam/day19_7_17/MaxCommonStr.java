package Exam.day19_7_17;

import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/07/19/20:18
 * @Description: 最长公共子串
 * 查找两个字符串a, b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
 * 注：子串的定义：将一个字符串删去前缀和后缀（也可以不删）形成的字符串。
 * 请和“子序列”的概念分开
 */
public class MaxCommonStr {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        if (str1.length()<str2.length()) {
            System.out.println(helper(str1,str2));
        } else {
            System.out.println(helper(str2,str1));
        }
    }
    public static String helper(String str1,String str2) {
        int maxLength = 0;
        int index = 0;
        int[][] dp = new int[str1.length()+1][str2.length()+1];

        for (int i = 1; i <= str1.length();i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        index = i - maxLength;
                    }
                }
            }
        }

        return str1.substring(index,index + maxLength);
    }
}
