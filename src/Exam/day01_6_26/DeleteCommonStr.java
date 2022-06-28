package Exam.day01_6_26;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/06/28/17:37
 * @Description:删除公共字符
 *输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。
 * 例如，输入”They are students.”和”aeiou”，
 * 则删除之后的第一个字符串变成”Thy r stdnts.”
 *
 */
public class DeleteCommonStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str2.length(); i++) {
            //当前拿到的字符，是否存在map中
            if (map.get(str2.charAt(i)) == null) {
                map.put(str2.charAt(i),1);
            } else {
                map.put(str2.charAt(i),map.get(str2.charAt(i))+1);
            }
        }
        StringBuffer sb = new StringBuffer();
        //遍历第一个字符串
        for (int i = 0; i < str1.length(); i++) {
            if (map.get(str1.charAt(i)) == null) {
                sb.append(str1.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}
