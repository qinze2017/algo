package LinkedList;

import java.util.List;

/**
 * @program: java_algo
 * @description: Given the head of a linked list, remove the nth node from the end of the list and return its head
 * @author: Ze QIN
 * @create: 2023-09-29 13:42
 **/
public class RemoveNodeEnd {

    ListNode head;

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int x) { val = x; next = null;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void push(int new_data)
    {
        ListNode new_node = new ListNode(new_data);
        new_node.next = head;
        head = new_node;
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy_head = new ListNode(0);
        dummy_head.next = head;

        ListNode slow = dummy_head;
        ListNode fast = dummy_head;

        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummy_head.next;

    }

    public ListNode getListNode() {
        return head;
    }

    public static void main(String[] args) {

        RemoveNodeEnd list = new RemoveNodeEnd();

        list.push(5);
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);

        System.out.println("Created Linked list is:");
        list.printList();

        list.removeNthFromEnd(list.getListNode(), 2);

        System.out.println("Linked List after Deletion of nth node from the end of the list :");
        list.printList();
    }
}
