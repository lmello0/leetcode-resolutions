import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SameTree {
    public static class TreeNode {
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

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode rootQ = new TreeNode(1);

        TreeNode node2Q = new TreeNode(2);
        TreeNode node3Q = new TreeNode(3);

        rootQ.left = node2Q;
        rootQ.right = node3Q;

        TreeNode rootP = new TreeNode(1);

        TreeNode node2P = new TreeNode(2);
        TreeNode node3P = new TreeNode(3);

        rootP.left = node2P;
        rootP.right = node3P;

        System.out.println(isSameTree(rootQ, rootP));
    }
}
