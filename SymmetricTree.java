import java.util.ArrayList;
import java.util.Stack;

public class SymmetricTree {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        SymmetricTree tree = new SymmetricTree();
        Node root = tree.createBinaryTree();
        boolean result = tree.isSymmetric(root);
        System.out.println(result);
    }

    private boolean isSymmetric(Node root) {
        leftTree(root.left);
        System.out.println();
        rightTree(root.right);
        System.out.println();
        for (Integer l: list) {
            if(stack.pop()!=l){
                return false;
            }
        }
        return true;
    }
    static ArrayList<Integer> list = new ArrayList<Integer>();
    static Stack<Integer> stack = new Stack<Integer>();
    private void leftTree(Node root){
        if(root.left!= null){
             leftTree(root.left);
        }
        System.out.print(root.data);
        list.add(root.data);
        if( root.right!=null){
            leftTree(root.right);
        }
    }
    private void rightTree(Node root){
        if(root.left!= null){
            rightTree(root.left);
        }
        System.out.print(root.data);
        stack.push(root.data);
        if( root.right!=null){
            rightTree(root.right);
        }
    }

    private Node createBinaryTree() {
        Node root = new Node(1);

        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.left = new Node(6);

        root.right = new Node(2);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        root.right.left.left = new Node(5);
        root.right.left.right = new Node(6);

        return root;
    }
}
