/* Structure of linked list Node
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node addOne(Node head) {
      head = reverse(head);
        Node current = head;
        int carry = 1; 
        while (current != null && carry > 0) {
            int sum = current.data + carry;
            current.data = sum % 10;
            carry = sum / 10;
            if (current.next == null && carry > 0) {
                current.next = new Node(carry);
                carry = 0;  
            }

            current = current.next;
        }

        
        head = reverse(head);
        return head;
    }
     Node reverse(Node node) {
        Node prev = null;
        Node current = node;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}