package Offer;

/**
 * @Author: Waterless
 * @Date: 2022/07/23/16:25
 * @Description: 剪绳子问题
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class Num14I {
    public int cuttingRope(int n) {
        //只切一刀 返回1
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            //切两刀 返回2
            return 2;
        }
        //初始化dp数组，因为当n>4的时候就有更多的选择，2和3要切的话值反而会变小。
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        //让从4开始
        for (int i = 4; i <= n; i++) {
            //看当前的dp[i]切j刀后的最大值
            for (int j = 1; j <= (i/2); j++) {
                //i时的乘积一定是他不切和切之间的最大值，切的话就是成绩，切了j刀，剩下的值就是i-j
                dp[i] = Math.max(dp[i],dp[i-j]*dp[j]);
            }
        }
        return dp[n];
    }
}
