class MinStack {
    Stack<Integer> st;
    Stack<Integer> min;
    public MinStack() {
        st = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        if (min.isEmpty()) {
            min.push(val);
        }else if (min.peek() >= val) {
            min.push(val);
        }
        st.push(val);
    }

    public void pop() {
        if(st.isEmpty()) return;
        if (st.peek().equals(min.peek()) ){
            st.pop();
            min.pop();
        }else{
            st.pop();
        }
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
