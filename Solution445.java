/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    // Approach #1 (利用栈先进后出)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        // resultNode, resultCurrent必须初始化
        ListNode resultNode = new ListNode(0); // 头节点
        ListNode resultCurrent = new ListNode(0); // 每次新插入的节点
        int carry = 0; // 进位
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            resultCurrent = new ListNode(stack1.pop() + stack2.pop() + carry);
            carry = resultCurrent.val / 10; // 计算进位
            resultCurrent.val = resultCurrent.val % 10; // 计算该位的数值

            // 构建链表方法：每次新建的节点插在head位置之前(头插法？)
            resultCurrent.next = resultNode.next;
            resultNode.next = resultCurrent;
        }
        while (!stack1.isEmpty()) // 链表l1比链表l2长，处理链表l1的高位
        {
            resultCurrent = new ListNode(stack1.pop() + carry);
            carry = resultCurrent.val / 10;
            resultCurrent.val = resultCurrent.val % 10;
            resultCurrent.next = resultNode.next;
            resultNode.next = resultCurrent;
        }
        while (!stack2.isEmpty()) // 链表l2比链表l1长，处理链表l2的高位
        {
            resultCurrent = new ListNode(stack2.pop() + carry);
            carry = resultCurrent.val / 10;
            resultCurrent.val = resultCurrent.val % 10;
            resultCurrent.next = resultNode.next;
            resultNode.next = resultCurrent;
        }
        if (carry > 0) // 最高位产生进位，需要新建节点进行存储
        {
            resultCurrent = new ListNode(carry);
            resultCurrent.next = resultNode.next;
            resultNode.next = resultCurrent;
        }
        return resultNode.next;
    }

    // Approach #2 (单链表实现反转模拟Add Two Numbers问题)
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
        l1 = reverse(l1); // 链表l1反转
        l2 = reverse(l2); // 链表l2反转
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
        return reverse(resultList); // 返回的链表进行反转操作后再返回
    }

    // 单链表实现反转操作函数
    public ListNode reverse(ListNode current) {
        // initialization
        ListNode previousNode = null;
        ListNode nextNode = null;

        while (current != null) {
            // save the next node
            nextNode = current.next;
            // update the value of "next"
            current.next = previousNode;
            // shift the pointers
            previousNode = current;
            current = nextNode;
        }
        return previousNode;
    }

}
