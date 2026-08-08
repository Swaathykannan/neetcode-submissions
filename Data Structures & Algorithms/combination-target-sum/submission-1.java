class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> combination = new ArrayList<>();
        backtrack(nums, combination, new ArrayList(), target,0,0);
        return combination;
    }

    private void backtrack(int[] nums, List<List<Integer>> combinations, List<Integer> current,int target, int sum,int index) {
        if (sum == target) {
            combinations.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (sum > target)
              return;
            current.add(nums[i]);
            backtrack(nums, combinations, current, target, sum + nums[i],i);
            current.remove(current.size() - 1);    
        }
    }
}
