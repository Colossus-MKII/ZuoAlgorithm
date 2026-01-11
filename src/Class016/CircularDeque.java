package Class016;

import java.util.Deque;
import java.util.LinkedList;

public class CircularDeque {
    class MyCircularDeque {
        public Deque<Integer> deque = new LinkedList<>();
        public int size;
        public int limit;

        public MyCircularDeque(int k) {
            size = 0;
            limit = k;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            deque.addFirst(value);
            ++size;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            deque.addLast(value);
            ++size;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            deque.pollFirst();
            --size;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            deque.pollLast();
            --size;
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return deque.peekFirst();
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return deque.peekLast();
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }

}
