package Class015;

import java.util.Stack;

public class GetMinStack {
    class MinStack {

        Stack<Integer> data;
        Stack<Integer> assist;

        public MinStack() {
            data = new Stack<>();
            assist = new Stack<>();
        }

        public void push(int val) {
            data.push(val);
            if (assist.isEmpty() || val <= assist.peek()) {
                assist.push(val);
            } else {
                assist.push(assist.peek());
            }
        }

        public void pop() {
            data.pop();
            assist.pop();
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return assist.peek();
        }
    }

}
