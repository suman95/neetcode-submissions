class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int i = 0 ; i < temperatures.length ; i++ ) {
            int curr_temp = temperatures[i];
            while(!s.isEmpty() && curr_temp >temperatures[s.peek()]) {
                int left = s.pop();
                result[left] = (i-left);
            }
            s.push(i);
        }
        return result;
    }
}
