class Solution {
    int longSeq = 0;
    public int lengthOfLIS(int[] nums) {
        int[] cache = new int[nums.length];
        if (nums.length == 1) {
            return 1;
        } else if (nums.length == 0) {
            return longSeq;
        } else if (nums.length == 2) {
            return nums[1] > nums[0] ? 2 : 1;
        }
        getLengthofLIS(nums, cache);
        return longSeq;
    }
    private void getLengthofLIS(int[] nums, int[] cache) {
        cache[0] = 1;
        cache[1] = nums[1] > nums[0] ? cache[0] + 1 : 1;
        longSeq = Math.max(cache[0], cache[1]);
        for (int i = 2; i < nums.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    cache[i] = Math.max(cache[i],1 + cache[j]);
                    longSeq = Math.max(longSeq, cache[i]);
                }
            }
            if (cache[i] == 0) {
                cache[i] = 1;
                longSeq = Math.max(longSeq, cache[i]);
            }
        }
    }
}
