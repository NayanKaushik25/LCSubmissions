class Solution {
    int[][] directions={{1,0},{0,1},{-1,0},{0,-1}};
    private void dfs(int[][] heights,int r,int c,boolean[][] visited) {
        visited[r][c]=true;
        for(int[] dir:directions) {
            int nr=r+dir[0];
            int nc=c+dir[1];
            if(nr<0 || nr>=heights.length || nc<0 || nc>=heights[0].length || visited[nr][nc]==true || heights[nr][nc]<heights[r][c]) {
                continue;
            }
            dfs(heights,nr,nc,visited);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans=new ArrayList<>();
        int m=heights.length;
        int n=heights[0].length;
        boolean[][] pacific=new boolean[m][n];
        boolean[][] atlantic=new boolean[m][n];
        for(int i=0;i<m;i++) {
            dfs(heights,i,0,pacific);
        }
        for(int j=0;j<n;j++) {
            dfs(heights,0,j,pacific);
        }
        for(int i=0;i<m;i++) {
            dfs(heights,i,n-1,atlantic);
        }
        for(int j=0;j<n;j++) {
            dfs(heights,m-1,j,atlantic);
        }
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) 
            {
                if(pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
}
