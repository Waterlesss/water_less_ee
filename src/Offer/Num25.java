package Offer;

/**
 * @Author: Waterless
 * @Date: 2022/07/04/15:56
 * @Description: 合并链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class Num25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return  l1;
        //定义虚拟头节点
        ListNode unrealHead = new ListNode(-1);
        ListNode node = unrealHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                node = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                node = l2;
                l2 = l2.next;
            }
        }
        //若有一个链表为空，直接将不为空的链表拼接到结果后面。
        node.next = l1 == null ? l2 : l1;
        return  unrealHead.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }
}
