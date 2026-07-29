class Solution {
    public int[] productExceptSelf(int[] nums) {
        int productArr[] = new int[nums.length];
        int prefixProd[] = new int[nums.length];
        int suffixProd[] = new int[nums.length];
        int product = 1;
        suffixProd[nums.length - 1] = 1;
        prefixProd[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefixProd[i] = nums[i - 1] * prefixProd[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            suffixProd[i] = nums[i + 1] * suffixProd[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            productArr[i] = suffixProd[i] * prefixProd[i];
        }
        return productArr;
    }
}
