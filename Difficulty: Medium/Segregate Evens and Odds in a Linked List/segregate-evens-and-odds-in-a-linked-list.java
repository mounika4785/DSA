/* Structure of a Linked List Node
class Node {
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}*/

class Solution {
    Node divide(Node head) {
        if (head == null || head.next == null)
            return head;

        Node evenHead = null;
        Node even = null;
        Node oddHead = null;
        Node odd = null;

        Node temp = head;

        while (temp != null) {
            if (temp.data % 2 == 0) {
                if (evenHead == null) {
                    evenHead = temp;
                    even = temp;
                } else {
                    even.next = temp;
                    even = even.next;
                }
            } else {
                if (oddHead == null) {
                    oddHead = temp;
                    odd = temp;
                } else {
                    odd.next = temp;
                    odd = odd.next;
                }
            }

            temp = temp.next;
        }

        if (evenHead == null)
            return oddHead;

        if (oddHead == null)
            return evenHead;

        even.next = oddHead;
        odd.next = null;

        return evenHead;
    }
}