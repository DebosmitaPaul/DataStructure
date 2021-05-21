/*
Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3is the length of the path [4,2,1,3] or [5,2,1,3].

Input: root = [1,2]
Output: 1

 */
public class BinaryTree_Diameter {
    public static void main(String[] args) {
        BinaryTree_Diameter bt = new BinaryTree_Diameter();
        TreeNode root = bt.createBinaryTree();
        maxDepth(root) ;
        System.out.println(maxDiameter);
    }
    static int maxDiameter =0;
    private static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);
        maxDiameter = Integer.max(maxDiameter,(lDepth+rDepth));
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
 //       root.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
//
        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(5);
//        root.right.right = new TreeNode(6);
//        root.right.left.left = new TreeNode(7);
//        root.right.left.right = new  TreeNode(8);

        return root;
    }
}

