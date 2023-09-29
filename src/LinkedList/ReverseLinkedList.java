package LinkedList;

import java.util.Stack;

/**
 * @program: java_algo
 * @description: Given the head of a singly linked list, reverse the list, and return the reversed list.
 * @author: Ze QIN
 * @create: 2023-09-29 16:04
 **/
public class ReverseLinkedList {

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

    public ListNode reverseList(ListNode node) {
        /*Iterative Approach 迭代法
        The time complexity of the above program is O(n), whereas the space complexity of the program is O(1),
        where n represents the total number of nodes present in the list.
        ListNode previous = null;
        ListNode current = node;

        while(current != null) {
            ListNode nextElement = current.next;
            current.next = previous;
            previous = current;
            current = nextElement;
        }

        head = previous;*/

        /*Recursive Approach 递归方法
        Step 1: Split the list given into two parts - the first node and the rest of the linked list.
        Step 2: Invoke the reverseList() method for the remaining portion of the linked list.
        Step 3: Join the rest to the first.
        Step 4: Fix the head pointer.
        The time complexity of the above program is O(n), whereas the space complexity of the program is O(1),
        where n represents the total number of nodes present in the list.
        Note that the above program uses the inbuilt stack because of the recursion.
        For the sake of simplicity, we have ignored the space consumed by the inbuilt stack.*/
        if (node == null || node.next == null)
        {
            return node;
        }
        ListNode rest = reverseList(node.next);
        node.next.next = node;

        node.next = null;

        head = rest;
        return head;
    }

    public ListNode reverseList(ListNode node, Stack<Integer> stk) {
        /* The time complexity of the above program is O(n), whereas the space complexity of the program is also O(n),
        where n represents the total number of nodes present in the list*/
        if (node == null || node.next == null)
        {
            return node;
        }
        while(node != null) {
            stk.push(node.val);
            node = node.next;
        }
        ListNode head = null;

        while(stk.empty() == false) {
            if (node == null) {
                head = new ListNode(stk.peek());
                node = head;
                stk.pop();
            } else {
                node.next = new ListNode(stk.peek());
                stk.pop();
                node = node.next;
            }
        }
        return head;
    }

    public ListNode reverseList(ListNode node, int size) {
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = node.val;
            node = node.next;
        }

        int i = size - 1;
        ListNode head = null;

        while (i >= 0) {
            if (head == null) {
                head = new ListNode(arr[i]);
                node = head;
            } else {
                node.next = new ListNode(arr[i]);
                node = node.next;
            }
            i = i - 1;
        }

        return head;
    }

    public ListNode getListNode() {
        return head;
    }

    public int countNodes(ListNode head) {
        int cnt = 0;
        while (head != null) {
            cnt = cnt + 1;
            head = head.next;
        }
        return cnt;
    }

    public static void main(String[] args) {

        ReverseLinkedList list = new ReverseLinkedList();

        list.push(5);
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);

        System.out.println("Created Linked list is:");
        list.printList();

        //list.reverseList(list.getListNode());

        Stack<Integer> stk = new Stack<Integer>();
        list.reverseList(list.getListNode(),stk);

        int size = list.countNodes(list.getListNode());
        list.reverseList(list.getListNode(), size);

        System.out.println("Linked List after Deletion of nth node from the end of the list :");
        list.printList();
    }
}
