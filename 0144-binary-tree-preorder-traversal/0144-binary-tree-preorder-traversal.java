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
    List<Integer> list ;
    TreeNode root ;
    public List<Integer> preorderTraversal(TreeNode root) {
        this.root = root ;
        this.list = new ArrayList<>() ;
        // solveRecursively(root) ;
        // solveIteratively() ;
        morrisTraversal() ;
        
        return list ;
        
    }
    private void solveRecursively(TreeNode root){
        if(root == null) return ;
        this.list.add(root.val) ;
        solveRecursively(root.left) ;
        solveRecursively(root.right) ;
    }
    private void solveIteratively(){
        Stack<TreeNode> stack = new Stack<>() ;
        
        stack.push(root) ;
        
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop() ;
            if(curr == null) continue ;
            list.add(curr.val) ;
            stack.push(curr.right) ;
            stack.push(curr.left) ;
        }
    }
    private void morrisTraversal(){
        TreeNode prev ;
        while(root != null){
            if(root.left == null){
                list.add(root.val) ;
                root = root.right ;
            }
            else{
                prev = root.left ;
                while(prev.right != null && prev.right != root){
                    prev = prev.right ;
                }
                if(prev.right == null){
                    list.add(root.val) ;
                    prev.right = root ;
                    root = root.left ;
                }
                else{
                    prev.right = null ;
                    root = root.right ;
                }
            }
        }
    }
}