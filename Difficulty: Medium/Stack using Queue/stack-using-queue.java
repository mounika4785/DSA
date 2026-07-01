import java.util.*;

class myStack {
    Queue<Integer> q = new LinkedList<>();

    void push(int x) {
        q.offer(x);

        int n = q.size();
        for (int i = 0; i < n - 1; i++) {
            q.offer(q.poll());
        }
    }

    void pop() {
        if (!q.isEmpty()) {
            q.poll();
        }
    }

    int top() {
        if (q.isEmpty()) {
            return -1;
        }
        return q.peek();
    }

    int size() {
        return q.size();
    }
}