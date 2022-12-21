/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    String ans = "~" ;
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans ;
    }
    private void dfs(TreeNode root, StringBuilder sb){
        if(root == null) return ;
        
        sb.append((char)('a'+root.val)) ;
        
        if(root.left == null && root.right == null){
            String tempAns = sb.reverse().toString() ;
            sb.reverse() ;
            
            ans = tempAns.compareTo(ans) < 0 ? tempAns : ans ;
        }
        
        dfs(root.left,sb) ;
        dfs(root.right,sb) ;
        sb.deleteCharAt(sb.length()-1);
    }
}