package LinkedList;

import org.w3c.dom.NodeList;

/**
 * @program: java_algo
 * @description: Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 * @author: Ze QIN
 * @create: 2023-10-09 15:13
 **/
public class PalindromeLinkedList {

    ListNode head;

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int x) { val = x; next = null;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondHalfHead = reverse(slow.next);
        ListNode firstHalfHead = head;

        while(secondHalfHead != null && firstHalfHead != null) {
            if (firstHalfHead.val != secondHalfHead.val) {
                return false;
            }
            secondHalfHead = secondHalfHead.next;
            firstHalfHead = firstHalfHead.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public void printList()
    {
        ListNode tnode = head;
        while (tnode != null) {
            System.out.print(tnode.val + " ");
            tnode = tnode.next;
        }
        System.out.print("\n");
    }

    public void push(int new_data)
    {
        ListNode new_node = new ListNode(new_data);
        new_node.next = head;
        head = new_node;
    }


    public static void main(String[] args) {
        PalindromeLinkedList list = new PalindromeLinkedList();

        list.push(1);
        list.push(2);
        list.push(3);
        //list.push(4);
        list.push(2);
        list.push(1);

        System.out.println("Created Linked list is:");
        list.printList();

        System.out.println(list.isPalindrome(list.head));
    }
}
