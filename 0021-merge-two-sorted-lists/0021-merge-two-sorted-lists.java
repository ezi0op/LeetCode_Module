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
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode temp3 = new ListNode();

        ListNode temp1 = temp3;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp1.next = list1;
                list1 = list1.next;
            } else {
                temp1.next = list2;
                list2 = list2.next;
            }

            temp1 = temp1.next;
        }

        temp1.next = (list1 != null) ? list1 : list2;

        return temp3.next;

    }
}