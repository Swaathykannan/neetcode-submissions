class Solution {
    public int rob(int[] nums) {
        int cache[]=new int[nums.length];
        Arrays.fill(cache,-1);
        return maxAmount(nums,cache);
    }

    private int maxAmount(int[] nums,int[] cache){
        if(nums.length==1){
            return nums[0];
        }else if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        cache[0]=nums[0];
        cache[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            cache[i]=Math.max(cache[i-1],nums[i]+cache[i-2]);
        }
        return cache[nums.length-1];
    }
}
