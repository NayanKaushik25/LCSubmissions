class Solution {
    private int ROWS, COLS;
    private Set<Pair<Integer, Integer>> path = new HashSet<>();

    private boolean dfs(char [][] board, int r,int c,int i,String word) {
        if(i==word.length()) {
            return true;
        }
        if(r<0 || c<0 || r>=ROWS || c>=COLS || path.contains(new Pair<>(r,c)) || board[r][c]!=word.charAt(i)) {
            return false;
        }
        path.add(new Pair<>(r,c));
        boolean res=(dfs(board,r+1,c,i+1,word) || dfs(board,r-1,c,i+1,word) || dfs(board,r,c+1,i+1,word) || dfs(board,r,c-1,i+1,word));
        path.remove(new Pair<>(r,c));
        return res;
    }
    public boolean exist(char[][] board, String word) {
        ROWS=board.length;
        COLS=board[0].length;
        for(int i=0;i<ROWS;i++) {
            for(int j=0;j<COLS;j++) {
                if(dfs(board,i,j,0,word)==true) {
                    return true;
                }
            }
        }
        return false;
    }
}