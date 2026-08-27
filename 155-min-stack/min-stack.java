class MinStack {
    int arr[];
    int top;

    public MinStack() {
        arr = new int[100000];
        top = -1;
    }

    public void push(int value) {
        arr[++top] = value;
    }

    public void pop() {
        if (top != -1) {
            top--;
        }
    }

    public int top() {
        return arr[top];
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;

        for (int i = top; i >= 0; i--) {
            min = Math.min(arr[i], min);
        }

        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */