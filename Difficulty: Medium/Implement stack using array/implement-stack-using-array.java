class myStack {
    int[] arr;
    int top;

    myStack(int size) {
        arr = new int[size];
        top = -1;
    }
    void push(int x) {
        if (!isFull()) {
            arr[++top] = x;
        }
    }
    void pop() {
        if (!isEmpty()) {
            top--;
        }
    }
    int peek() {
        if (isEmpty()) {
            return -1;
        }
        return arr[top];
    }

    boolean isEmpty() {
        return top == -1;
    }
    boolean isFull() {
        return top == arr.length - 1;
    }
}