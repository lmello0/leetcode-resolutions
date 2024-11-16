package dataStructures;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree {
    private class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        private TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    TreeNode root;

    public void insert(int val) {
        if (this.root == null) {
            this.root = new TreeNode(val);
            return;
        }

        insertRecursive(val, root);
    }

    private void insertRecursive(int val, TreeNode node) {
        if (val < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
                return;
            }

            insertRecursive(val, node.left);
            return;
        }

        if (node.right == null) {
            node.right = new TreeNode(val);
            return;
        }

        insertRecursive(val, node.right);
    }

    public boolean search(int val) {
        return searchRecursive(root, val);
    }

    private boolean searchRecursive(TreeNode node, int val) {
        if (node == null) {
            return false;
        }

        if (node.val == val) {
            return true;
        }

        if (val < node.val) {
            return searchRecursive(node.left, val);
        } else {
            return searchRecursive(node.right, val);
        }
    }

    public List<Integer> preorderTraversal() {
        List<Integer> result = new ArrayList<>();

        this.preorderTraversalRecursive(root, result);

        return result;
    }

    private void preorderTraversalRecursive(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);
            this.preorderTraversalRecursive(node.left, result);
            this.preorderTraversalRecursive(node.right, result);
        }
    }

    public List<Integer> inorderTraversal() {
        List<Integer> result = new ArrayList<>();

        this.inorderTraversalRecursive(root, result);

        return result;
    }

    private void inorderTraversalRecursive(TreeNode node, List<Integer> result) {
        if (node != null) {
            this.inorderTraversalRecursive(node.left, result);
            result.add(node.val);
            this.inorderTraversalRecursive(node.right, result);
        }
    }

    public List<Integer> postorderTraversal() {
        List<Integer> result = new ArrayList<>();

        this.postorderTraversalRecursive(root, result);

        return result;
    }

    private void postorderTraversalRecursive(TreeNode node, List<Integer> result) {
        if (node != null) {
            this.inorderTraversalRecursive(node.left, result);
            this.inorderTraversalRecursive(node.right, result);
            result.add(node.val);
        }
    }

    public boolean dfs(int val) {
        return dfsRecursive(root, val);
    }

    private boolean dfsRecursive(TreeNode node, int val) {
        if (node == null) {
            return false;
        }

        if (node.val == val) {
            return true;
        }

        return dfsRecursive(node.left, val) || dfsRecursive(node.right, val);
    }

    public boolean bfs(int val) {
        if (root == null) {
            return false;
        }

        Deque<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();

            if (node.val == val) {
                return true;
            }

            if (node.left != null) {
                queue.addLast(node.left);
            }

            if (node.right != null) {
                queue.addLast(node.right);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(5);
        tree.insert(3);
        tree.insert(1);
        tree.insert(10);
        tree.insert(15);
        tree.insert(7);

        System.out.println(tree.bfs(7));
    }
}
