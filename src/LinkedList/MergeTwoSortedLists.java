package LinkedList;

import java.util.Arrays;
import java.util.List;

/**
 * @program: java_algo
 * @description: You are given the heads of two sorted linked lists list1 and list2.  Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.  Return the head of the merged linked list.
 * @author: Ze QIN
 * @create: 2023-10-06 18:15
 **/
public class MergeTwoSortedLists {

    ListNode head;

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void push(int new_data)
    {
        ListNode new_node = new ListNode(new_data);
        new_node.next = head;
        head = new_node;
    }

    public void printList(ListNode node)
    {
        ListNode tnode = head;
        if (node != null) {
            tnode = node;
        }
        while (tnode != null) {
            System.out.print(tnode.val + " ");
            tnode = tnode.next;
        }
        System.out.print("\n");
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null)
        {
            return list1 == null ? list2 : list1;
        }

        /*a recursive function
        Time complexity:O(n).
        Only one traversal of the linked lists are needed.
        Auxiliary Space:O(n).
        If the recursive stack space is taken into consideration.
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
        */

        /* Iterative */
        if (list1.val < list2.val) {
           return mergeNodeList(list1, list2);
        } else {
           return mergeNodeList(list2, list1);
        }
    }

    static ListNode mergeNodeList(ListNode list1, ListNode list2) {

        if (list1.next == null) {
            list1.next = list2;
            return list1;
        }

        ListNode current1 = list1, next1 = list1.next;
        ListNode current2 = list2, next2 = list2.next;

        while (next1 != null && current2 != null) {

            if (current2.val >= current1.val && current2.val <= next1.val) {
                next2 = current2.next;
                current1.next = current2;
                current2.next = next1;

                current1 = current2;
                current2 = next2;
            } else {
                if (next1.next != null) {
                    next1 = next1.next;
                    current1 = current1.next;
                } else {
                    next1.next = current2;
                    return list1;
                }
            }
        }
        return list1;
    }

    public ListNode getListNode() {
        return head;
    }

    public static void main(String[] args) {

        MergeTwoSortedLists list1 = new MergeTwoSortedLists();
        MergeTwoSortedLists list2 = new MergeTwoSortedLists();
        MergeTwoSortedLists list = new MergeTwoSortedLists();

        list1.push(4);
        list1.push(2);
        list1.push(1);

        list2.push(4);
        list2.push(3);
        list2.push(1);

        list1.printList(null);
        list2.printList(null);

        ListNode merged = list.mergeTwoLists(list1.getListNode(), list2.getListNode());

        System.out.println("Linked List after Deletion of nth node from the end of the list :");
        list.printList(merged);
    }
}
