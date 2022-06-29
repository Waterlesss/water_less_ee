package Offer;

/**
 * @Author: Waterless
 * @Date: 2022/06/29/23:42
 * @Description: 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
public class Num04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        //从二维数组的最后一列开始查找
        int x = matrix[0].length -1;
        //从二维数组的第一行开始查找
        int y = 0;
        while (x >= 0 && y < matrix.length) {
            //比二维数组该列的最小值还要小，直接查找上一列
            if (target < matrix[y][x]) {
                x--;
            }
            else if (target > matrix[y][x]) {
                //比该行的最大值还大，查找下一行
                y++;
            }else {
                return true;
            }
        }
        return false;
    }
}
