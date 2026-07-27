class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int j = i + 1;
            // boolean targetReached=false;
            while (j < numbers.length) {
                int sum = numbers[i] + numbers[j];
                if (sum == target) {
                    // targetReached=true;
                    return new int[] {i + 1, j + 1};
                } else if (sum < target) {
                    j++;
                } else {
                    break;
                }
            }
        }
        return new int[0];
    }
}
