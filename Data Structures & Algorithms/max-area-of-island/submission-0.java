class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m] ;
        int max=0;
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(vis[row][col]==0&&grid[row][col]==1){
                    vis[row][col]=1;
                    max=Integer.max(max,bfs(vis,grid,row,col));
                }
            }
        }
        return max;
    }

    public int bfs(int vis[][],int grid[][],int row,int col){
        Queue<Index> queue=new LinkedList<>();
        int area=0;
        queue.add(new Index(row,col));
        while(!queue.isEmpty()){
            area++;
            row=queue.peek().first;
            col=queue.peek().second;
            queue.remove();
            int rowdir[]={-1,+1,0,0};
            int coldir[]={0,0,-1,+1};
            for(int i=0;i<4;i++){
                int nextrow=row+rowdir[i];
                int nextcol=col+coldir[i];
                if(nextrow>=0 && nextrow<grid.length && nextcol>=0 && nextcol<grid[0].length && vis[nextrow][nextcol] ==0 && grid[nextrow][nextcol]==1){
                    vis[nextrow][nextcol]=1;
                    queue.add(new Index(nextrow,nextcol));
                }
            }
        }
        return area;

    }

}
class Index{
    int first;
    int second;
    Index(int first,int second){
        this.first=first;
        this.second=second;
    }
}
