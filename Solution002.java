/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // resultList, resultNode, resultNext必须初始化，否则编译不通过
        ListNode resultList = null; // 返回链表
        ListNode resultNode = null; // 头节点
        ListNode resultNext = null; // 每次新插入的节点
        int carry = 0; // 进位
        while(l1 != null && l2 != null){
            resultNext = new ListNode(l1.val + l2.val + carry);
            carry = resultNext.val / 10; // 计算进位
            resultNext.val = resultNext.val % 10; // 计算该位的数值

            if (resultList == null) { // 头节点为空，即插入的节点为返回链表的第一个节点时
                resultNode = resultNext;
                resultList = resultNext;
            }
            else { // 头节点不为空
                resultNode.next = resultNext;
                resultNode = resultNext;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) // 链表l1比链表l2长，处理链表l1的高位
        {
            resultNext = new ListNode(l1.val + carry);
            carry = resultNext.val / 10;
            resultNext.val = resultNext.val % 10;
            resultNode.next = resultNext;
            resultNode = resultNext;
            l1 = l1.next;
        }
        while (l2 != null) // 链表l2比链表l1长，处理链表l2的高位
        {
            resultNext = new ListNode(l2.val + carry);
            carry = resultNext.val / 10;
            resultNext.val = resultNext.val % 10;
            resultNode.next = resultNext;
            resultNode = resultNext;
            l2 = l2.next;
        }
        if (carry > 0) // 最高位产生进位，需要新建节点进行存储
        {
            resultNext = new ListNode(carry);
            resultNode.next = resultNext;
        }
        return resultList;
    }
}
