import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        this.inorderTraversalRecursive(root, result);

        return result;
    }

    private void inorderTraversalRecursive(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            inorderTraversalRecursive(root.left, result);
        }

        result.add(root.val);

        if (root.right != null) {
            inorderTraversalRecursive(root.right, result);
        }
    }
}
