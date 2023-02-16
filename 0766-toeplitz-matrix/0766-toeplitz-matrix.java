class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i=0; i<matrix.length; i++){
            int row = i ;
            int col = 0 ;
            int e = matrix[row][col] ;
            while(row < matrix.length && col < matrix[0].length){
                if(e != matrix[row++][col++]) return false ;
            }
        }
        for(int j=0; j<matrix[0].length; j++){
            int col = j ;
            int row = 0 ;
            int e = matrix[row][col] ;
            while(row < matrix.length && col < matrix[0].length){
                if(e != matrix[row++][col++]) return false ;
            }
        }
        return true ;
    }
}