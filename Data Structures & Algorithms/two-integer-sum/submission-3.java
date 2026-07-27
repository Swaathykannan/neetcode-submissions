class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sumIndex = new int[2];
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (numsMap.containsKey(difference)) {
                sumIndex[1] = i;
                sumIndex[0] = numsMap.get(difference);
                break;
            }
            numsMap.put(nums[i], i);
        }
        return sumIndex;
    }
}
