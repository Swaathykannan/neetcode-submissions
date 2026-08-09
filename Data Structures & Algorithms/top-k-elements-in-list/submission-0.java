class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        int result[] = new int[k];
        for (int i = 0; i < nums.length; i++) {
            frequencyMap.merge(nums[i], 1, Integer::sum);
        }
        PriorityQueue<Integer> minHeap =
            new PriorityQueue<>((a ,b)-> Integer.compare(frequencyMap.get(a), frequencyMap.get(b)));
        for (Integer value : frequencyMap.keySet()) {
            minHeap.add(value);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }
}
