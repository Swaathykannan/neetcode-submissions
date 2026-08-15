class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int value : nums) {
            sum += value;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int[][] cache = new int[nums.length][(sum / 2) + 1];
        return isPartition(nums, cache, 0, sum / 2);
    }

    private boolean isPartition(int[] nums, int[][] cache, int index, int sum) {
        if (sum == 0) {
            return true;
        }
        if (index >= nums.length) {
            return false; // ran out of elements, target never hit exactly 0
        }
        if (cache[index][sum] != 0) {
            return cache[index][sum] == 1 ? true : false;
        }
        boolean resultInclude = false;
        boolean resultExclude = false;
        if (sum - nums[index] >= 0) {
            resultInclude = isPartition(nums, cache, index + 1, sum - nums[index]);
            cache[index][sum - nums[index]] = resultInclude ? 1 : 2;
        }
        resultExclude = isPartition(nums, cache, index + 1, sum);
        cache[index][sum] = resultExclude ? 1 : 2;
        return resultInclude || resultExclude;
    }
}
