class Solution {

    class Dir{ 
        int source;
        int dest;
        int delay;
        Dir(int source, int dest, int delay) {
            this.source = source;
            this.dest = dest;
            this.delay = delay;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Integer[]>> adj = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        int[] delays = new int[n+1];
        for(int i = 0 ; i < n+1; i++) {
            delays[i] = Integer.MAX_VALUE;
        }
        for(int[] time : times) {
            List<Integer[]> temp = adj.getOrDefault(time[0], new ArrayList<>());
            temp.add(new Integer[]{time[1], time[2]});
            adj.put(time[0], temp);
        }
        PriorityQueue<Dir> pq = new PriorityQueue<>((a,b)-> a.delay - b.delay);
        for(Integer[] path : adj.getOrDefault(k,new ArrayList<>())) {
            pq.offer(new Dir(k, path[0], path[1]));
        }
        visited.add(k);
        while(!pq.isEmpty()) {
            Dir curr = pq.poll();
            if(visited.contains(curr.dest)) continue;
            visited.add(curr.dest);
            delays[curr.dest] = Math.min(delays[curr.dest], curr.delay);
            for(Integer[] path : adj.getOrDefault(curr.dest, new ArrayList<>())) {
                if(!visited.contains(path[0])) {
                    pq.offer(new Dir(curr.dest, path[0], curr.delay + path[1]));
                }
            }
        }
        if(visited.size() < n) return -1;
        int maxDelay = -1;
        for(int i = 1; i < delays.length; i++) {
            if(delays[i] != Integer.MAX_VALUE)
                maxDelay = Math.max(maxDelay, delays[i]);
        }
        return  maxDelay;
    }
}
