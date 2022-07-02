package Exam.day05_6_30;

import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/07/02/15:46
 * @Description: 连续最大和
 * 一个数组有 N 个元素，求连续子数组的最大和。
 * 例如：[-1,2,1]，和最大的连续子数组为[2,1]，其和为 3
 */
public class ContinueMaxSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int sum = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            //判断子数组大还是本身大
            sum = Math.max(sum+arr[i],arr[i]);
            if (sum > max) {
                max = sum;
            }
        }
        System.out.println(max);
    }
}
