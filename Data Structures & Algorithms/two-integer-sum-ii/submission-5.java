class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0;
        int j=i+1;
        while (i < numbers.length - 1) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[] {i + 1, j + 1};
            } else if (sum < target) {
                j++;
            } else{ 
                i++;
                j = i + 1;
            }
            if(j>=numbers.length){
                i++;
                j = i + 1;
            }
        }
        return new int[0];
    }
}
