public class PathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetsum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && targetsum == root.val) {
            return true;
        }

        return hasPathSum(root.left, targetsum - root.val) || hasPathSum(root.right, targetsum - root.val);
    }
}
