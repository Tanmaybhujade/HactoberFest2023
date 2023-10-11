/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for(ListNode head : lists) while(head != null) {
            pq.add(head);
            head = head.next;
        }

        if(pq.isEmpty()) return null;

        ListNode head = pq.poll(), current = head;
        while(!pq.isEmpty()) {
            current.next = pq.poll();
            current = current.next;
        }
        current.next = null;

        return head;
    }
}
