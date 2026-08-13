class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        int n = 0;
        ListNode temp = head;

        while (temp != null) {
            n++;
            temp = temp.next;
        }

        k = k % n;

        return rotate(head, k);
    }

    public ListNode rotate(ListNode head, int k) {
        if (k == 0)
            return head;

        ListNode temp = head;
        ListNode prev = null;

        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }

        prev.next = null;
        temp.next = head;
        head = temp;

        return rotate(head, k - 1);
    }
}