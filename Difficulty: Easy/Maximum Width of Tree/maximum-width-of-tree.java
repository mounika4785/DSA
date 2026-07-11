/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */

class Solution {
    int maxWidth(Node root) {
        if (root == null)
            return 0;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int maxWidth = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            maxWidth = Math.max(maxWidth, size);

            for (int i = 0; i < size; i++) {

                Node curr = q.poll();

                if (curr.left != null)
                    q.offer(curr.left);

                if (curr.right != null)
                    q.offer(curr.right);
            }
        }

        return maxWidth;
    }
}
      