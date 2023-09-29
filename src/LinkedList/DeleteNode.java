package LinkedList;

import sun.plugin.dom.core.Node;

import java.util.LinkedList;

/**
 * @program: java_algo
 * @description: here is a singly-linked list head and we want to delete a node node in it.
 * @author: Ze QIN
 * @create: 2023-09-28 18:41
 **/
public class DeleteNode {

    ListNode head;

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
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

    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }

    public ListNode getListNode() {

        ListNode value = head;
        while (value != null) {
            if (value.val == 1) {
                return value;
            }
            value = value.next;
        }

        return head;
    }

    public static void main(String[] args) {

        DeleteNode list = new DeleteNode();

        list.push(9);
        list.push(1);
        list.push(5);
        list.push(4);

        System.out.println("Created Linked list is:");
        list.printList();

        list.deleteNode(list.getListNode());

        System.out.println("Linked List after Deletion of 1:");
        list.printList();
    }
}
