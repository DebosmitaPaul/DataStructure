public class ConvertToSumTree {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        ConvertToSumTree tree = new ConvertToSumTree();
        Node root = tree.createBinaryTree();
        tree.printTree(root);
        System.out.println();

        tree.convertSumTree(root);
        tree.printTree(root);
    }

    private void printTree(Node root) {
        System.out.print(root.data + " ");
        if(root.left!=null){
            printTree(root.left);
        }
        if(root.right!=null){
            printTree(root.right);
        }
    }

    private int convertSumTree(Node root) {
        if(root== null){
            return 0;
        }
        int leftData = convertSumTree(root.left);
        int rightData = convertSumTree(root.right);
        int oldData = root.data;
        root.data = leftData+rightData;
        return root.data+oldData;
    }

    private Node createBinaryTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.right = new Node(4);

        root.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        return root;
    }
}
