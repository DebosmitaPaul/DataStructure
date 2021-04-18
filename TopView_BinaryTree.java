public class TopView_BinaryTree {

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TopView_BinaryTree tree = new TopView_BinaryTree();
        Node root = tree.createBinaryTree();
        tree.printTopView(root);
    }

    private void printTopView(Node root) {
        printLeft(root.left);
        System.out.print(root.data + " ");
        printRight(root.right);
    }
    void printLeft(Node root){
        if(root.left!=null){
            printLeft(root.left);
        }
        System.out.print(root.data+ " ");
    }
    void printRight(Node root){
        System.out.print(root.data+ " ");
        if (root.right!= null){
            printRight(root.right);
        }
    }

    private Node createBinaryTree() {
        Node root = new Node(1);

        root.left = new Node(2);
        root.left.left = new Node(10);
        root.left.right = new Node(4);

        root.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.right.right = new Node(60);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        return root;
    }
}
