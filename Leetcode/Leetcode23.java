Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
       if(lists.length == 0) return null;
        ListNode dummy = new ListNode(0);
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(11, new Comparator<ListNode>(){
            public int compare(ListNode n1, ListNode n2){
                return n1.val - n2.val;
            }
        });

        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null) q.offer(lists[i]);
        }
        ListNode curr = dummy;
        while(!q.isEmpty()){
            curr.next = q.poll();
            curr = curr.next;
            if(curr.next != null){
                q.offer(curr.next);    
            }
        }
        return dummy.next;
    }
}
