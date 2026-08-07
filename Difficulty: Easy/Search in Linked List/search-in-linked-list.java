/*
  class Node {
   int data;
    Node next;

    Node(int d)  { data = d;  next = null; }
}
*/
class Solution {
    public boolean searchKey(Node head, int key) {
        Node newnode = new Node(key);
        Node temp = head;
        while(temp != null){
            if(temp.data == newnode.data)
              return true;
            temp = temp.next;
        }
      return false;  
    }
}