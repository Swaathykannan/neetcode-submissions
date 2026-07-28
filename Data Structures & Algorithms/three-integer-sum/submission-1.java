class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> sumSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                if (nums[i] + nums[low] + nums[high] == 0) {
                    sumSet.add(List.of(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                } else if (nums[i] + nums[low] + nums[high] > 0) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return sumSet.stream().toList();
    }
}
