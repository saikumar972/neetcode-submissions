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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 != null) {
            return list2;
        } else if (list2 == null && list1 != null) {
            return list1;
        } else if (list1 == null && list2 == null) {
            return null;
        } else {
            ListNode temp1 = list1;
            ListNode temp2 = list2;
            ListNode temp = new ListNode(100);
            ListNode tail = temp;
            while (temp1 != null && temp2 != null) {
                if (temp1.val <= temp2.val) {
                    tail.next = temp1;
                    temp1 = temp1.next;
                } else {
                    tail.next = temp2;
                    temp2 = temp2.next;
                }
                tail = tail.next;
            }
            tail.next = temp1 != null ? temp1 : temp2;
            return temp.next;
        }
    }

}