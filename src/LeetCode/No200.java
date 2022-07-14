package LeetCode;

/**
 * @Author: Waterless
 * @Date: 2022/07/14/17:40
 * @Description: 岛屿的数量
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 */
public class No200 {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid,i,j);
                    //求的是被0包围的1 不是求单个1的个数
                    count++;
                }
            }
        }
        return count;
    }
    //深度优先搜索
    private void dfs(char[][] grid, int i, int j) {
        //边界条件 当超过二维数组的长度或者等于0时返回
        if (i < 0 || j <0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        //走到这里说明当前二维数组的值为1，将其修改为0，避免重复递归
        grid[i][j] = '0';
        //向当前位置的四个方向继续判断
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
