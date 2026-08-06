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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> q=new ArrayDeque<>();
        q.offer(root);
        boolean flag=true;

        while(!q.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            int n=q.size();
            while(n-- > 0){
                TreeNode node=q.poll();
                if(flag) temp.add(node.val);
                else temp.add(0,node.val);

                if(node.left!=null) q.offer(node.left);
                if(node.right!=null)q.offer(node.right);
            }
            ans.add(temp);
            flag=!flag;
        }
        return ans;
    }
}