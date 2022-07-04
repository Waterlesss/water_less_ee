package Offer;

import java.util.HashMap;

/**
 * @Author: Waterless
 * @Date: 2022/07/04/16:34
 * @Description: 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class Num52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode A = headA;
        ListNode B = headB;
        //两个指针同时往后走，若两个链表的长度相同，则会相遇，直接返回
        //若两链表长度不相同，当A链表走到最后一个结点时，再从B链表的头节点开始走。同理B也如此
        //当两个指针第二次遍历链表时，二者必然会相遇
        while (A != B) {
            if (A != null) {
                A = A.next;
            } else {
                A = headB;
            }
            if (B != null) {
                B = B.next;
            } else {
                B = headA;
            }
        }
        return A;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }
}
