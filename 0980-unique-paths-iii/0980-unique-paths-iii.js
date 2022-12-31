/**
 * @param {number[][]} grid
 * @return {number}
 */
var uniquePathsIII = function(grid) {
    var paths = 0 ;
    let emptySquares = 1 ; // counting destination as emptySquare
    let startRow, startCol ;
    
    for(let i=0; i<grid.length; i++){
        for(let j=0; j<grid[0].length; j++){
            if(grid[i][j] == 0){
                emptySquares++ ;
            }
            else if(grid[i][j] == 1){
                startRow = i ;
                startCol = j ;
            }
        }
    }
    function dfs(r,c,visited,target,grid){
        
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c] == -1) return ;
        
        if(grid[r][c] == 2){
            if(visited == target) paths++ ;
            return ;
        }
        
        let temp = grid[r][c] ;
        grid[r][c] = -1 ; 
        
        dfs(r,c+1,visited+1,target,grid) ;
        dfs(r,c-1,visited+1,target,grid) ;
        dfs(r+1,c,visited+1,target,grid) ;
        dfs(r-1,c,visited+1,target,grid) ;
        
        grid[r][c] = temp ;
    }
    dfs(startRow,startCol,0,emptySquares,grid) ;
    return paths ;
};