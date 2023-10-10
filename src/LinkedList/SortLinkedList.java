package LinkedList;

/**
 * @program: java_algo
 * @description: Sort
 * @author: Ze QIN
 * @create: 2023-10-09 15:20
 **/
public class SortLinkedList {

    //ListNode head;
    ListNode head = null;
    ListNode sorted;

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

    public void sortedList() {

        /*Bubble Sort
        two pointers: current and index.
        Traverse through the list till current points to null, by comparing current’s data with index’s data.
        And for each current’s value, index is the next to current node which traverse from current’s next node till null.
        And then the value of current node is compared with every value from its next node till last and if the value is smaller
        than the current value, then the values are swapped and in this way the least value comes as current index.
        Time complexity: O(n ^ 2)
        Auxiliary Space: O(1)*/
        // current will point to head
        ListNode current = head, index = null;

        int temp;

        if (head == null) {
            return;
        } else {
            while (current != null) {
                // Node index will point to next to current
                index = current.next;
                while (index != null) {
                    if (current.val > index.val) {
                        temp = current.val;
                        current.val = index.val;
                        index.val = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    public void insertionSort(ListNode node) {
        sorted = null;
        ListNode current = node;

        while (current != null) {
            ListNode next = current.next;
            sortedInsertList(current);
            current = next;
        }
        head = sorted;
    }

    public void sortedInsertList(ListNode newnode) {
         /* Insertion Sort
         all the elements before the current element in the list is already sorted, and we begin with the current element.
         The current element is compared with all the elements before it and swapped if not in order. This process is repeated for all the subsequent elements.
         In general, the Insertion sort technique compares each element with all of its previous elements and sorts the element to place it in its proper position.
         Linked lists have pointers pointing to its next element (singly linked list) and previous element (double linked list)
         Time complexity: O(n ^ 2)
         Auxiliary Space: O(1)
         */

        if (sorted == null || sorted.val >= newnode.val) {
            newnode.next = sorted;
            sorted = newnode;
        } else {
            ListNode current = sorted;

            while (current.next != null && current.next.val < newnode.val) {
                current = current.next;
            }

            newnode.next = current.next;
            current.next = newnode;
        }

    }

    public ListNode partitionLast(ListNode start, ListNode end){

        /*Time complexity: O(n ^ 2)
        Auxiliary Space: O(1)
         */
        if (start == end || start == null || end == null) {
            return start;
        }

        ListNode pivot_prev = start;
        ListNode current = start;
        int pivot = end.val;

        // iterate till one before the end,
        // no need to iterate till the end
        // because end is pivot
        while (start != end) {
            if (start.val < pivot) {
                // keep tracks of last modified item
                pivot_prev = current;
                int temp = current.val;
                current.val = start.val;
                start.val = temp;
                current = current.next;
            }
            start = start.next;
        }

        int temp = current.val;
        current.val = pivot;
        end.val = temp;

        return pivot_prev;

    }

    public void quickSorted(ListNode start, ListNode end) {

        if (start == end) {
            return;
        }

        ListNode pivot_prev = partitionLast(start, end);

        quickSorted(start, pivot_prev);

        // if pivot is picked and moved to the start,
        // that means start and pivot is same
        // so pick from next of pivot
        if (pivot_prev != null && pivot_prev == start) {
            quickSorted(pivot_prev.next, end);

        }
        // if pivot is in between of the list,
        // start from next of pivot,
        // since we have pivot_prev, so we move two nodes
        else if (pivot_prev != null && pivot_prev.next != null){
            quickSorted(pivot_prev.next.next, end);
        }
    }

    public ListNode sortedMerge(ListNode left, ListNode right) {
        ListNode result = null;

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        if (left.val < right.val) {
            result = left;
            result.next = sortedMerge(left.next, right);
        } else {
            result = right;
            result.next = sortedMerge(left, right.next);
        }

        return result;
    }

    public ListNode mergeSort(ListNode node) {

        if (node == null || node.next == null) {
            return node;
        }

        //get the middle of the list
        ListNode middle = getMiddle(node);
        ListNode nextToMiddle = middle.next;

        // set the next of middle node to null
        middle.next = null;

        // Apply mergeSort on left list
        ListNode left = mergeSort(node);

        // Apply mergeSort on right list
        ListNode right = mergeSort(nextToMiddle);

        // Merge the left and right lists
        ListNode sortedlist = sortedMerge(left, right);

        return sortedlist;

    }

    //get the middle of the linked list
    public ListNode getMiddle(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode getListNode() {
        return head;
    }

    public static void main(String[] args) {

        SortLinkedList list = new SortLinkedList();

        list.push(5);
        list.push(3);
        list.push(2);
        list.push(4);
        list.push(1);

        System.out.println("Created Linked list is:");
        list.printList(list.head);

        //list.sortedList();
        //list.insertionSort(list.head);

        /*ListNode n = list.head;
        while (n.next != null) n = n.next;

        list.quickSorted(list.head, n);*/

        list.head = list.mergeSort(list.head);


        System.out.println("Linked List after Deletion of nth node from the end of the list :");
        list.printList(list.head);
    }

}
