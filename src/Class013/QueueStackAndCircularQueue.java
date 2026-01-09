package Class013;

import java.time.chrono.IsoChronology;

public class QueueStackAndCircularQueue {
    class MyCircularQueue {
        public int[] queue;
        public int l, r, size, limit;

        public MyCircularQueue(int k) {
            queue = new int[k];
            l = r = size = 0;
            limit = k;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            queue[r] = value;
            r = (r + 1 == limit) ? 0 : r + 1;
            ++size;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            l = (l == limit - 1) ? 0 : l + 1;
            --size;
            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return queue[l];
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            int last = (r == 0) ? (limit - 1) : (r - 1);
            return queue[last];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }
}
