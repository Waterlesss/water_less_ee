package Offer;

/**
 * @Author: Waterless
 * @Date: 2022/07/08/11:31
 * @Description:  股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * 动态规划
 */
public class Num63 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int min = prices[0];
        int res = 0;

        for (int i = 0; i < prices.length; i++) {
            //数组中的最小值
            min = Math.min(min,prices[i]);
            //卖出的最大值 比较已有最大值和当前遍历到的值
            res = Math.max(res,prices[i] - min);
        }
        return res;
    }
}
