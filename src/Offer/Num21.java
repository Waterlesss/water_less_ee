package Offer;

/**
 * @Author: Waterless
 * @Date: 2022/07/04/21:45
 * @Description: 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 *
 * 双指针去判断奇偶
 */
public class Num21 {
    public int[] exchange(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        return helepr(nums,0,nums.length - 1);
    }

    private int[] helepr(int[] nums, int i, int j) {
        while (i < j) {
            //从数组头部开始判断，碰到奇数继续++
            while (i < j && ((nums[i] & 1) == 1)) {
                i++;
            }
            //从数组尾部往前判断，碰到偶数继续--；
            while (i < j && ((nums[j] & 1) == 0)) {
                j--;
            }
            //此时i碰到第一个不是奇数的值，j碰到第一个不是偶数的值，交换奇数和偶数的位置
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}
