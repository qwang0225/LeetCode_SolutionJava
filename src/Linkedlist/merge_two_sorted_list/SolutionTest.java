package Linkedlist.merge_two_sorted_list;

import Linkedlist.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @org.junit.jupiter.api.Test
    void mergeTwoListsTest() {
        Solution sol = new Solution();
        // Initialize first list [1, 2, 4]
        ListNode l1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(4);
        l1.next = l1_2;
        l1_2.next = l1_3;

        // Initialize second list [1, 3, 4, 5]
        ListNode l2 = new ListNode(1);
        ListNode l2_2 = new ListNode(3);
        ListNode l2_3 = new ListNode(4);
        ListNode l2_4 = new ListNode(5);
        l2.next = l2_2;
        l2_2.next = l2_3;
        l2_3.next = l2_4;


        // Merge the two lists
        ListNode cur = sol.mergeTwoLists(l1, l2);
        int[] expected = {1, 1, 2, 3, 4, 4, 5};
        int i = 0;
        while (cur != null){
            assertEquals(expected[i], cur.val);
            cur = cur.next;
            i++;
        }

        // Initialize third list [1, 3, 4]
        // merge the first and third lists
        ListNode l3 = new ListNode(1);
        ListNode l3_2 = new ListNode(3);
        ListNode l3_3 = new ListNode(4);
        l3.next =l3_2;
        l3_2.next = l3_3;

        cur = sol.mergeTwoLists(l1, l3);
        int[] expected2 = {1, 1, 2, 3, 4, 4};
        for (int j = 0; j < expected2.length; j++){
            assertEquals(expected2[j], cur.val);
            cur = cur.next;
        }

    }
}