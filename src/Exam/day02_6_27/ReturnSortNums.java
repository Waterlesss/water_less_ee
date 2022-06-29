package Exam.day02_6_27;

import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/06/29/22:07
 * @Description: 排序子序列
 * 牛牛可以把数组A划分为[1,2,3]和[2,2,1]两个排序子序列,
 * 至少需要划分为2个排序子序列,所以输出2
 */
public class ReturnSortNums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        //防止数组越界
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        //索引下标
        int i = 0;
        //子序列的个数
        int count = 0;
        while (i < n) {
            if (arr[i] > arr[i+1]) {
                while (i < n - 1 && arr[i] > arr[i + 1]) {
                    //一直都是递增的序列
                    i++;
                }
                //碰到不是递增的序列，说明有一个子序列 count+1
                i++;
                count++;
            } else if (arr[i] == arr[i+1]) {
                i++;
            }else {
                if (arr[i] < arr[i + 1]) {
                    while (i < n - 1 && arr[i] < arr[i + 1]) {
                        i++;
                    }
                    i++;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
