class Solution {
    int walks = 0 ;
    public int uniquePathsIII(int[][] grids) {

        int[] source = {-1,-1} ,destination = {-1,-1} ;
        int emptySquares = 0 ;

        for(int i=0; i<grids.length; i++){
            for(int j=0; j<grids[0].length; j++){
                if(grids[i][j] == -1) continue;
                else if(grids[i][j] == 1){
                    source = new int[]{i,j} ;
                    grids[i][j] = 0 ;
                }
                else if(grids[i][j] == 2){
                    destination = new int[]{i,j} ;
                    grids[i][j] = 0 ;
                }
                emptySquares++ ;
            }
        }

        f(source[0],source[1], destination, grids, 1, emptySquares) ;
        return walks ;
    }

    private void f(int r, int c, int[] dest, int[][] grids, int count, int target){

        if(r == dest[0] && c == dest[1]){
            if(count == target) walks++ ;
            return ;
        }

        grids[r][c] = -1 ;

        int[][] moves = {{0,1},{0,-1},{1,0},{-1,0}} ;

        for(int i=0; i<4; i++){
            int x = r + moves[i][0] ;
            int y = c + moves[i][1] ;

            if(isValid(x,y,grids)){
                f(x,y,dest,grids,count+1,target) ;
            }
        }

        grids[r][c] = 0 ;
    }
    private boolean isValid(int r, int c, int[][] grids){
        return r>=0 && c>=0 && r<grids.length && c<grids[0].length && grids[r][c] == 0 ;
    }
}