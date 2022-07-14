package LeetCode;

/**
 * @Author: Waterless
 * @Date: 2022/07/14/21:21
 * @Description: 不同路径
 * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角。
 *
 * 问总共有多少条不同的路径？
 */
public class No62 {
    public int uniquePaths(int m, int n) {
        //建立二维数组
        int[][] dp = new int[m][n];
        //将边界初始化为1
        //因为画图我们可以得出 第f(i,j)个格子得路径走法是f(i-1,j) + f(i,j-1);
        //数组得边界上面没有元素 所以就是1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][ n -1 ];
    }
}
