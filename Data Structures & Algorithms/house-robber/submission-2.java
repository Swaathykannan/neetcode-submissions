class Solution {
    public int rob(int[] nums) {
        int cache[]=new int[nums.length];
        Arrays.fill(cache,-1);
        return maxAmount(nums,cache,nums.length-1);
    }

    private int maxAmount(int[] nums,int[] cache,int index){
        if(index<0){
            return 0;
        }
        if(cache[index]!=-1){
            return cache[index];
        }
        cache[index]=Math.max(maxAmount(nums,cache,index-1),nums[index]+maxAmount(nums,cache,index-2));
        return cache[index];
    }
}
