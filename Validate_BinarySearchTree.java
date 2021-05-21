import java.util.ArrayList;
import java.util.List;

/*
Input: root = [5,1,4,null,null,3,6]
Output: false

Input: root = [2,1,3]
Output: true

 */
public class Validate_BinarySearchTree {
    boolean isValidBST(TreeNode root) {
        List<Integer> mylist = new ArrayList<Integer>();
        inOrder(root, mylist);
        for (int i = 1; i < mylist.size(); i++) {
            if(mylist.get(i-1) >= mylist.get(i)){
                return false;
            }
        }
        return true;
    }
    void inOrder(TreeNode root, List<Integer> mylist){
        if(root==null){
            return;
        }
        if(root.left != null ){
            inOrder(root.left, mylist);
        }
        mylist.add(root.val);
        if(root.right != null){
            inOrder(root.right, mylist);
        }
    }
    public static void main(String[] args) {
        Validate_BinarySearchTree bst = new Validate_BinarySearchTree();
        TreeNode root = bst.createTree();

        System.out.println(bst.isValidBST(root));
    }
    TreeNode createTree(){
        //[5,1,4,null,null,3,6]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);

        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        return root;
    }

    class TreeNode {
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
}
