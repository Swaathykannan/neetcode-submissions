class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sumIndex = new int[2];
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (numsMap.containsKey(difference) && numsMap.get(difference) != i) {
                sumIndex[0] = i;
                sumIndex[1] = numsMap.get(difference);
                break;
            }
        }
        return sumIndex;
    }
}
