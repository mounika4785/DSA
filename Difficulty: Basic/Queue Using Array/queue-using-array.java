class myQueue {

    int arr[];
    int start;
    int end;
    int currsize;
    int maxsize;

    public myQueue(int n) {
        arr = new int[n];
        start = -1;
        end = -1;
        currsize = 0;
        maxsize = n;
    }

    public boolean isEmpty() {
        return currsize == 0;
    }

    public boolean isFull() {
        return currsize == maxsize;
    }

    public void enqueue(int x) {

        if (currsize == maxsize) {
            System.exit(1);
        }

        currsize++;

        if (end == -1) {
            start = 0;
            end = 0;
        } 
        else {
            end = (end + 1) % maxsize;
        }

        arr[end] = x;
    }

    public int dequeue() {

        if (currsize == 0) {
            System.exit(1);
        }

        int popped = arr[start];

        if (currsize == 1) {
            start = -1;
            end = -1;
        } 
        else {
            start = (start + 1) % maxsize;
        }

        currsize--;

        return popped;
    }

    public int getFront() {

        if (start != -1) {
            return arr[start];
        }

        return -1;
    }

    public int getRear() {

        if (end != -1) {
            return arr[end];
        }

        return -1;
    }
}