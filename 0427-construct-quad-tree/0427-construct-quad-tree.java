/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return f(0,grid.length-1,0,grid.length-1,grid);
    }
    private Node f(int sr, int er, int sc, int ec, int[][] grid){
        if(sr == er) return new Node(grid[sr][sc] == 1,true);
        
        int midR = (sr+er+1) >> 1 ;
        int midC = (sc+ec+1) >> 1 ;
        boolean isLeaf = isLeaf(sr,er,sc,ec,grid);
        boolean value = !isLeaf ? false : grid[sr][sc] == 1 ;

        Node node = new Node(value,isLeaf);
        if(!isLeaf){
        node.topLeft = f(sr,midR-1,sc,midC-1,grid);
        node.topRight = f(sr,midR-1,midC,ec,grid);
        node.bottomLeft = f(midR,er,sc,midC-1,grid);
        node.bottomRight = f(midR,er,midC,ec,grid);
        }
        
        return node;
    }
    private boolean isLeaf(int sr, int er, int sc, int ec, int[][] grid){
        for(int i=sr; i<=er; i++){
            for(int j=sc; j<=ec; j++){
                if(grid[i][j] != grid[sr][sc]) return false;
            }
        }
        return true;
    }
}