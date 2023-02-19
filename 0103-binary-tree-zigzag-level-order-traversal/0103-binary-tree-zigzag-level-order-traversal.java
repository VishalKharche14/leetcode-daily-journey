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
    public List<List<Integer>> list = new ArrayList();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return list;
        zigzag(root);
        return list;
    }
    public void zigzag(TreeNode root){
        boolean reverse = false;
        Queue<TreeNode> q  = new LinkedList();
        List<Integer> l = new ArrayList();
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty()){
            TreeNode temp = q.remove();
            if(temp==null){
                
                if(reverse) Collections.reverse(l);
                reverse = reverse ? false : true ;
                
                list.add(new ArrayList(l));
                l.clear();
                
                if(q.isEmpty()) return;
                q.add(null);
            }
            else{
                l.add(temp.val);
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
        }  
    }
}