class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ;
        int count = 0 ;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    dfs(i,j,grid) ;
                    count++ ;
                }        
            }
        }
        
        return count ;
    }
    private void dfs(int r, int c , char[][] grid){
        
        grid[r][c] = '2' ; // visited
        
        int[][] moves = {{0,-1},{0,1},{-1,0},{1,0}} ;
        for(int i=0; i<4; i++){
            int x = r + moves[i][0] ;
            int y = c + moves[i][1] ;
            
            if(x >= 0 && y >= 0 && x < grid.length && y< grid[0].length && grid[x][y] == '1'){
                dfs(x,y,grid) ;
            }
        }
    }
}