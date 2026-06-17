class MyCircularQueue {
    final int queue[];
    int f, r,l;

    public MyCircularQueue(int k) {
        queue = new int[k];
        r = -1;
        l = 0;
        f = 0;
    }

    public boolean enQueue(int value) {
        if (!isFull()) {
            r = (r + 1) % queue.length;
            queue[r] = value;
            l++;
            return true;
        } else
            return false;
    }

    public boolean deQueue() {
        if (!isEmpty()) {
            f = (f + 1) % queue.length;
            l--;
            return true;
        } else
            return false;
    }

    public int Front() {
        return isEmpty() ? -1 : queue[f];
    }

    public int Rear() {
        return isEmpty() ? -1 : queue[r];
    }

    public boolean isEmpty() {
        return l == 0;
    }

    public boolean isFull() {
        return l == queue.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */