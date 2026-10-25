class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        Set<String> operators = new HashSet<>();
        operators.addAll(Arrays.asList(new String[]{"+", "-", "*", "/"}));
        for(int i = 0; i < tokens.length ; i++) {
            if(operators.contains(tokens[i])) {
                Integer second = Integer.valueOf(st.pop());
                Integer first = Integer.valueOf(st.pop());
                switch(tokens[i]) {
                    case "+" : st.push(Integer.toString(first + second)); break;
                    case "-" : st.push(Integer.toString(first - second)); break;
                    case "*" : st.push(Integer.toString(first * second)); break;
                    case "/" : st.push(Integer.toString(first / second)); break;
                }
            } else {
                st.push(tokens[i]);
            }
        }
        return st.isEmpty() ? 0 : Integer.valueOf(st.pop());
    }
}
