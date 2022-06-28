package Exam.day01_6_26;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/06/28/17:00
 * @Description: 组队竞赛
 * 牛牛举办了一次编程比赛,参加比赛的有3*n个选手,每个选手都有一个水平值a_i.
 * 现在要将这些选手进行组队,一共组成n个队伍,即每个队伍3人.
 * 牛牛发现队伍的水平值等于该队伍队员中第二高水平值。
 * 输出一个整数表示所有队伍的水平值总和最大值
 */
public class Compete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[3 * n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextLong();
        }
        Arrays.sort(arr);
        int sum = 0;
        for (int i = n; i < arr.length; i+=2) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
