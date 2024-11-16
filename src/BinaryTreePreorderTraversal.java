import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        preorderTraversalRecursive(root, result);

        return result;
    }

    private void preorderTraversalRecursive(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);

        if (root.left != null) {
            preorderTraversalRecursive(root.left, result);
        }

        if (root.right != null) {
            preorderTraversalRecursive(root.right, result);
        }
    }
}
