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
    public ListNode removeNthFromEnd(ListNode head, int k) {
        ListNode dummy = new ListNode(100);
        dummy.next = head;
        ListNode headPointer = dummy;
        ListNode trailPointer = dummy;

        while (k > 0) {
            headPointer = headPointer.next;
            k--;
        }

        while (headPointer.next != null) {
            headPointer = headPointer.next;
            trailPointer = trailPointer.next;
        }

        trailPointer.next = trailPointer.next.next;

        return dummy.next;
    }
}