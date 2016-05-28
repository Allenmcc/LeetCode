package medium;



/**
 * Created by danny on 16/5/25.
 */

class TreeNode {
        int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

public class CalculateRobValue {
    public static void main(String args[]){

        CalculateRobValue calculateRobValue = new CalculateRobValue();
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(1);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = null;
        treeNode2.right = treeNode4;
        treeNode3.left = null;
        treeNode3.right = treeNode5;
        treeNode4.left = treeNode4.right = null;
        treeNode5.left = treeNode5.right = null;
        int result = calculateRobValue.rob(treeNode1);

         System.out.println(result);
    }

    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;

        int left = 0, right = 0;
        int subleft = 0, subright = 0;

        if (root.left != null) {
            left = rob(root.left);
            subleft = rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            right = rob(root.right);
            subright = rob(root.right.left) + rob(root.right.right);
        }

        int sum1 = left + right;
        int sum2 = subleft + subright + root.val;

        return (sum1 > sum2) ? sum1 : sum2;
    }
}
