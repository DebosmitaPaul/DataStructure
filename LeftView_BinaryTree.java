import java.lang.reflect.Array;
import java.util.ArrayList;

public class LeftView_BinaryTree {
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    static ArrayList<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) {
        LeftView_BinaryTree tree = new LeftView_BinaryTree();
        Node root = tree.createBinaryTree();
        System.out.print("Left view : ");
        tree.printLeftView(root);
        //Node node =
        //tree.LCA(4, 5,root);
    }

//    private void LCA(int data1, int data2, Node root) {
//        if(root.left.data == data1 && root.right.data == data2){
//            System.out.println("LCA : "+ root.data);
//            //return root;
//        }
//        else if(root.left!=null && root){
//            root = root.left;
//            LCA(root);
//        }
//        else{
//
//        }
//    }

    private void printLeftView(Node root) {
        System.out.print(root.data + " ");

        if(root.left != null){
            printLeftView(root.left);
        }
        if(root.right != null){
            if( root.right.left != null) {
                printLeftView(root.right.left);
            }
            else if(root.right.left.left!= null){
                printLeftView(root.right.left.left);
            }
        }
        list.add(root.data);
    }

    private Node createBinaryTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.left.right.left.left = new Node(90);

        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.left = new Node(9);
        root.right.left.left.left = new Node(100);
        root.right.left.left.left.left = new Node(110);

        root.right.right.left = new Node(10);
        return root;
    }
}
