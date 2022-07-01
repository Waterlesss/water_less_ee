package Exam.day03_6_28;

import java.util.Arrays;

/**
 * @Author: Waterless
 * @Date: 2022/07/01/16:40
 * @Description: 数组中出现次数超过一半的数字
 * 给一个长度为 n 的数组，数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 */
public class NumCount {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) return 0;
        int mid = array.length >> 1;
        //统计数字出现的次数
        int count = 0;
        Arrays.sort(array);
        //排完序后，出现次数超过数组长度一半的元素一定是数组中间的元素
        for (int i = 0; i < array.length; i++) {
            if (array[i] == array[mid]) count++;
        }
        if (count > array.length >> 1) return array[mid];
        return 0;
    }
}
