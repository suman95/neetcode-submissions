class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++)  pq.add(nums[i]);
        result.add(pq.peek());
        int left = 0;
        for (int right = k; right < nums.length; right++) {
            pq.remove(nums[left]);
            pq.add(nums[right]);
            result.add(pq.peek());
            left++;
        }
        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
