package Offer;

import com.sun.imageio.plugins.gif.GIFImageReader;

/**
 * @Author: Waterless
 * @Date: 2022/07/22/17:22
 * @Description: 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * 因为每次只能向右或者向下移动
 *使用动态规划去做，我们通过画图不难得出，当前格子的最大价值等于起上方和左方的最大值加上自己的价值
 */
public class Num47 {
    public int maxValue(int[][] grid) {
        //方法1：
//        int[][] dp = new int[grid.length+1][grid[0].length+1];
//        for (int i = 1; i <= grid.length; i++) {
//            for (int j = 1; j <= grid[0].length; j++) {
//                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + grid[i-1][j-1];
//            }
//        }
//        return dp[dp.length-1][dp[0].length-1];
        
        //方法2：直接在原数组进行相加，先初始化第一行和第一列,当前格子的值等于 += 上一个和做一个格子的最大值
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i-1][0];
        }
        for (int j = 1; j < grid.length; j++) {
            grid[0][j] += grid[0][j-1];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] = Math.max(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
    
}
