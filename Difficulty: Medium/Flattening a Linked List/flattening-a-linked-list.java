class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.data, b.data)
        );

        Node temp = head;

        while (temp != null) {
            pq.add(temp);
            temp = temp.next;
        }

        Node dummy = new Node(-1);
        Node curr = dummy;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            curr.bottom = node;
            curr = node;

            if (node.bottom != null) {
                pq.add(node.bottom);
            }

            curr.next = null;
        }

        return dummy.bottom;
    }
}