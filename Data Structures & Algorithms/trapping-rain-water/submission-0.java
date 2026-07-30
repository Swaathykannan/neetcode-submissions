class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int prefixHigh[]=new int[n];
        int suffixHigh[]=new int[n];
        prefixHigh[0]=0;
        suffixHigh[n-1]=0;
        int max=0;
        for(int i=1;i<n;i++){
            prefixHigh[i]=Math.max(prefixHigh[i-1],height[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            suffixHigh[i]=Math.max(suffixHigh[i+1],height[i+1]);
        }
        for(int i=0;i<n;i++){
            int result=Math.min(prefixHigh[i],suffixHigh[i])-height[i];
            if(result>0){
                max+=result;
            }
        }
        return max;
    }
}
