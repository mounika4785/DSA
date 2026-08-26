class myStack {
    Queue<Integer> q = new LinkedList<>();

    void push(int x) {
        q.add(x);

        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.poll());
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