/* Structure of Linked List Node
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}*/

class Solution {
    public int lengthOfLoop(Node head) {
        Node fast = head;
        Node slow = head;
        Node res = null;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                Node ptr1 = head;
                Node ptr2 = slow;

                while (ptr1 != ptr2) {
                    ptr1 = ptr1.next;
                    ptr2 = ptr2.next;
                }

                res = ptr1;
                break;
            }
        }

        if (res == null) {
            return 0;
        }

        int length = 1;
        Node temp = res.next;

        while (temp != res) {
            temp = temp.next;
            length++;
        }

        return length;
    }
}