package Exam.day15_7_12;

/**
 * @Author: Waterless
 * @Date: 2022/07/12/21:43
 * @Description: 手套问题
 * 在地下室里放着n种颜色的手套，手套分左右手，但是每种颜色的左右手手套个数不一定相同。
 * A先生现在要出门，所以他要去地下室选手套。但是昏暗的灯光让他无法分辨手套的颜色，
 * 只能分辨出左右手。所以他会多拿一些手套，然后选出一双颜色相同的左右手手套。
 * 现在的问题是，他至少要拿多少只手套(左手加右手)，才能保证一定能选出一双颜色相同的手套。
 *
 * 给定颜色种数n(1≤n≤13),同时给定两个长度为n的数组left,right,
 * 分别代表每种颜色左右手手套的数量。数据保证左右的手套总数均不超过26，
 * 且一定存在至少一种合法方案。
 */
public class Glove {
    public static void main(String[] args) {
        int[] arr1 = {0,7,1,6};
        int[] arr2 = {1,5,0,6};
        System.out.println(findMinimum(4, arr1, arr2));
    }
    public static int findMinimum(int n, int[] left, int[] right) {
        // write code here
        int leftMin = 26; //手套最大数量是26
        int rightMin = 26; 
        int leftSum = 0; 
        int rightSum = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] * right[i] == 0) {
                //如果有一个颜色的手套左手个数是0个 那么右边的也不能用
                //得全部拿出来
                sum += left[i];
                sum += right[i];
            } else {
                //求出不为0的手套的所有数量 和 数量最少的手套
                //最后从数量最少的手套里只取一个 比较两边手套数量最少的
                // 然后再从另一边任取一只手套 就能保证 一定能拿到一双手套
                leftSum = leftSum + left[i];
                rightSum = rightSum + right[i];
                leftMin = Math.min(leftMin,left[i]);
                rightMin = Math.min(rightMin,right[i]);
            }
        }
        int count = sum + 1 + Math.min((leftSum - leftMin) + 1,(rightSum - rightMin) + 1);
        return count;
    }
}
