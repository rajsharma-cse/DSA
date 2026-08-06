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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root == null ) return ans;
        Deque<TreeNode> q=new ArrayDeque<>();
        q.offerLast(root);
        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> temp=new ArrayList<>();

            while(n-- > 0){
                TreeNode node=q.pollFirst();
                temp.add(node.val);
                if(node.left!=null) q.offerLast(node.left);
                if(node.right!=null) q.offerLast(node.right);
            }
            ans.add(temp);
        }
        return ans;
    }
}