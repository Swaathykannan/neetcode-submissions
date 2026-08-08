class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutation = new ArrayList<>();
        boolean[] present = new boolean[nums.length];
        backTrack(present, permutation, new ArrayList(), nums);
        return permutation;
    }

    private void backTrack(
        boolean[] present, List<List<Integer>> permutation, List<Integer> current, int[] nums) {
        if (current.size() == nums.length) {
            permutation.add(new ArrayList(current));
            return;
        }

        for (int i = 0; i < present.length; i++) {
            if (present[i]) {
                continue;
            }
            current.add(nums[i]);
            present[i] = true;
            backTrack(present, permutation, current, nums);
            current.remove(current.size() - 1);
            present[i] = false;
        }
    }
}
