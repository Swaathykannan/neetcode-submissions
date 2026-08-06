class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subSet=new ArrayList<>();
        backTrack(nums,0,new ArrayList<>(),subSet);
        return subSet;
    }
    private void backTrack(int[] nums,int index,List current,List<List<Integer>> subSet){
        if(index==nums.length){
            subSet.add(new ArrayList<>(current));
            return;
        }
        backTrack(nums,index+1,current,subSet);
        current.add(nums[index]);
        backTrack(nums,index+1,current,subSet);
        current.remove(current.size()-1);
    }
}
