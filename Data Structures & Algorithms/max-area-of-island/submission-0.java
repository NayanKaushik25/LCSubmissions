class Solution {
    boolean[][] visited;
    private int dfs(int[][] grid,int r,int c) {
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==0) {
            return 0;
        }
        grid[r][c]=0;
        int res=1;
        res+=dfs(grid,r+1,c)+dfs(grid,r,c+1)+dfs(grid,r-1,c)+dfs(grid,r,c-1);
        return res;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int ROWS=grid.length;
        int COLS=grid[0].length;
        int area=0;
        for(int i=0;i<ROWS;i++) {
            for(int j=0;j<COLS;j++) {
                if(grid[i][j]==1) {
                    area=Math.max(area,dfs(grid,i,j));
                }
            }
        }
        return area;
    }
}
