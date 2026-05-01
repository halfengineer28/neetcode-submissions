class MinStack {
    Stack<Integer> st;
    Stack<Integer> min;
    public MinStack() {
        st = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {

        if (min.isEmpty() || min.peek() >= val){
                min.push(val);
        }

        st.push(val);

      
      
      
    }

    public void pop() {
        if(st.isEmpty()){
                return;
        }

        if (st.peek().equals(min.peek())){
                min.pop();
        }
        st.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min.isEmpty() ? -1 : min.peek();
    }
}
