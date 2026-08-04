class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int[] t : prerequisites) {
            graph.computeIfAbsent(t[1],k->new ArrayList<>()).add(t[0]);
            indegree[t[0]]+=1;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0 ; i < numCourses; i++) {
            if(indegree[i] == 0)
                q.offer(i);
        }
        int course = 0;
        while (!q.isEmpty()) {
            int temp = q.poll();
            course++;
            if(graph.containsKey(temp)) {
                for (int k : graph.get(temp)) {
                    indegree[k] -= 1;
                    if (indegree[k] == 0) {
                        q.offer(k);
                    }
                }
            }
        }
        return (course==numCourses);
    }
}
