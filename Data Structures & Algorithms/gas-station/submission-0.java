class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0;
        int totalCost = 0;
        for(int i = 0 ; i < n ; i ++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }        
        if(totalGas < totalCost) {
            return -1;
        }

        int currGas = 0;
        int rem = 0;
        int ind = 0;
        for(int i = 0 ; i < n; i++) {
            currGas = gas[i] + rem;
            if(cost[i] > currGas) {
                ind = i+1;
                rem = 0;
            } else {
                rem = currGas - cost[i];
            }
        }
        return ind;
    }
}

