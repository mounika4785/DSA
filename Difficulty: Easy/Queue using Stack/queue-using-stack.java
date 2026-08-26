import java.util.Stack;

class myQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void enqueue(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        s1.push(x);

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    void dequeue() {
        if (!s1.isEmpty()) {
            s1.pop();
        }
    }

    int front() {
        if (s1.isEmpty()) {
            return -1;
        }

        return s1.peek();
    }

    int size() {
        return s1.size();
    }
}