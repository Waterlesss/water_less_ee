package Exam.day_06_7_01;

import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/07/04/9:41
 * @Description: 不要二
 * 二货小易有一个W*H的网格盒子，网格的行编号为0~H-1，网格的列编号为0~W-1。
 * 每个格子至多可以放一块蛋糕，任意两块蛋糕的欧几里得距离不能等于2。
 * 小易想知道最多可以放多少块蛋糕在网格盒子里。
 */public class No2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int H = scan.nextInt();
        int W = scan.nextInt();
        //二维数组，初始化全为0
        int[][] arr = new int[H][W];
        //如果碰到为0的，计数器加一，表示可以放一个蛋糕
        int count = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (arr[i][j] == 0) {
                    count++;
                    //距离+2的格子不能放蛋糕，将所有距离+2的格子值置为 1
                    if (i + 2 < H && arr[i+2][j] == 0) {
                        arr[i+2][j] = 1;
                    }
                    if (j + 2 < W && arr[i][j+2] == 0) {
                        arr[i][j+2] =1;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
