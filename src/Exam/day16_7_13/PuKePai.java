package Exam.day16_7_13;

import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/07/15/20:16
 * @Description: 扑克牌游戏
 * 给定两个手牌 比较大小
 */
public class PuKePai {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String[] str2 = str1.split("-");
        String[] pk1 = str2[0].split(" ");
        String[] pk2 = str2[1].split(" ");
        String pk3 = "345678910JQKA2";
        if (str2[0].equals("joker JOKER") || str2[1].equals("joker JOKER")) {
            System.out.println("joker JOKER");
        } else if (pk1.length == pk2.length) {
            //由于手牌是排过序的 所以只需要判断两个手牌的第一张牌在扑克牌堆中出现的顺序大小即可
            if (pk3.indexOf(pk1[0]) > pk3.indexOf(pk2[0])) {
                System.out.println(str2[0]);
            } else {
                System.out.println(str2[1]);
            }
        } else if (pk1.length == 4) {
            System.out.println(str2[0]);
        } else if (pk2.length == 4) {
            System.out.println(str2[1]);
        } else{
            System.out.println("ERROR");
        }
    }
}
