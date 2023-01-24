class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int steps = 0 ;

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(null);

        while(!q.isEmpty()){
            Integer currPos = q.remove();
            if(currPos == null){
                steps++ ;
                if(!q.isEmpty()) q.add(null);
                continue ;
            }
            if(currPos == n*n) return steps ;
            
            for(int move : Arrays.asList(1,2,3,4,5,6)){
                int nextPos = currPos+move ;
                if(nextPos <= n*n){
                    int row = getRow(nextPos,n);
                    int col = getCol(nextPos,n);
                    if(board[row][col]!=-2){
                        q.add(board[row][col] == -1 ? nextPos : board[row][col]);
                        board[row][col] = -2 ;
                    }
                }
            }
        }
        return -1 ;
    }

    private int getCol(int nextSquare, int rows) {
        int currRow = getRow(nextSquare,rows);
        boolean reverse = ((rows&1)==1 && (currRow&1)==1) || (rows%2==0 && currRow%2==0) ;
        return reverse ? rows-(nextSquare-((rows-currRow-1)*rows)) : nextSquare-((rows-currRow-1)*rows)-1 ;
    }

    private int getRow(double nextSquare, int rows) {
        return rows-(int)Math.ceil(nextSquare/rows);
    }
}