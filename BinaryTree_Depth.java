/*
* A binary tree's maximum depth is the number of nodes along
* the longest path from the root node down to the farthest leaf node.
* */

public class BinaryTree_Depth {
    public static void main(String[] args) {
        BinaryTree_Depth bt = new BinaryTree_Depth();
        TreeNode root = bt.createBinaryTree();
        int result = bt.maxDepth(root) ;
        System.out.println("Depth of binary tree :"+result);
    }

    private int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);
        return Integer.max(lDepth,rDepth) + 1;
    }

    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }
    private TreeNode createBinaryTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new  TreeNode(8);

        return root;
    }
}

