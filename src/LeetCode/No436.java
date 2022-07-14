package LeetCode;

/**
 * @Author: Waterless
 * @Date: 2022/07/14/23:12
 * @Description: 岛屿的周长
 * 给定一个 row x col 的二维网格地图 grid ，
 * 其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。
 * 整个网格被水完全包围，但其中恰好有一个岛屿（
 * 或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。
 * 格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。
 * 计算这个岛屿的周长。
 */
public class No436 {
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //是岛屿才进行dfs计算周长
                if (grid[i][j] == 1) {
                    return dfs(grid,i,j);
                }
            }
        }
        return 0;
    }
    //深度优先遍历
    private int dfs(int[][] grid, int i, int j) {
        //边界条件 数组越界或者值等于0时返回1
        //返回1是因为此时走到了不是岛的格子 那么此时肯定有一个边长
        //从一个岛屿方格走向一个非岛屿方格，就将周长加 1
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 1;
        }
        //防止被重复判断
        if (grid[i][j] != 1) {
            return 0;
        }
        //防止无限递归，遍历过的岛屿进行污染
        grid[i][j] = -1;
        return dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1);
    }
}
