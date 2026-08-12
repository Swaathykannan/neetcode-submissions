class Solution {
    int combination=0;
    public int climbStairs(int n) { 
        int cache[]=new int[n+1];
        Arrays.fill(cache,-1);
        return backTrack(n,cache);
    }
     private int backTrack(int n,int[] cache){
        if(n==0||n==1){
            return 1;
        }
        if(cache[n]!=-1){
            return cache[n];
        }
        cache[n]=backTrack(n-1,cache)+backTrack(n-2,cache);
        return cache[n];
     }
}
