Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || m>n) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        head = dummyNode;
        for(int i=1;i<m;i++) {
            if(head==null) {
                return null;
            }
            head = head.next;
        }

        ListNode pre = head;
        ListNode fNode = head.next;
        ListNode lastNode = null;
        ListNode curNode= fNode;
        for(int i=m;i<=n;i++) {
            ListNode tmp = curNode.next;
            curNode.next = lastNode;
            lastNode = curNode;
            curNode = tmp;
        }
        pre.next = lastNode;
        fNode.next = curNode;

        return dummyNode.next;

    }
}
