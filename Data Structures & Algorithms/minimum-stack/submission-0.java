class MinStack {

    class Pair {
        int value,min;
        Pair(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }
    Stack<Pair> st;
    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        if(st.isEmpty()) st.push(new Pair(val,val));
        else {
            st.push(new Pair(val, Integer.min(val,st.peek().min)));
        }
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek().value;
    }

    public int getMin() {
        return st.peek().min;
    }
}
