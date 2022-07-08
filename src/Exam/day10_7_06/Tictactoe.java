package Exam.day10_7_06;

/**
 * @Author: Waterless
 * @Date: 2022/07/08/20:02
 * @Description: 井字棋
 * 给定一个二维数组board，代表棋盘，
 * 其中元素为1的代表是当前玩家的棋子，0表示没有棋子，-1是对方玩家的棋子。
 * 当一方棋子在横竖斜方向上有连成排的及获胜（及井字棋规则），返回当前玩家是否胜出。
 */
public class Tictactoe {
    public boolean checkWon(int[][] board) {
        // write code here
        int n = board.length;
        int sum = 0, i = 0, j = 0;
        //检查行
        for (i = 0; i < n; i++) {
            sum = 0;
            for (j = 0; j < n; j++) {
                sum = sum + board[i][j];
            }
            if (sum == n) return true;
        }
        //检查列
        for (i = 0; i < n; i++) {
            sum = 0;
            for (j = 0; j < n; j++) {
                sum = sum + board[j][i];
            }
            if (sum == n) return true;
        }
        //检查主对角线
        sum = 0;
        for (i = 0; i < n; i++) {
            sum = sum + board[i][i];
        }
        if (sum == n) return true;
        //检查副对角线
        sum = 0;
        for (j = 0; j < n; j++) {
            sum = sum + board[j][ n - j - 1];
        }
        if (sum == n) return true;
        return false;
    }
}
