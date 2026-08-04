class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int[] pre : prerequisites) {
            int preq = pre[1];
            int course = pre[0];
            graph.computeIfAbsent(preq, k->new ArrayList<>()).add(course);
            indegree[course]+=1;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0 ; i < numCourses ; i++) {
            if(indegree[i] == 0) q.offer(i);
        }
        List<Integer> path = new ArrayList<>();
        int course = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            path.add(curr);
            course++;
            if(graph.containsKey(curr)) {
                for(int val : graph.get(curr)) {
                    indegree[val]--;
                    if(indegree[val] == 0) q.offer(val);
                }
            }
        }
        if(course == numCourses) return path.stream().mapToInt(Integer::intValue).toArray();
        return new int[0];
    }
}
