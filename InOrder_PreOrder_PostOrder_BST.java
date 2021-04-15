public class InOrder_PreOrder_PostOrder_BST {
    class Node{
        int data;
        Node left = null;
        Node right = null;
        Node(int data){
            this.data = data;
        }
    }
    public static void main(String[] args) {
        InOrder_PreOrder_PostOrder_BST tree = new InOrder_PreOrder_PostOrder_BST();
        Node root = tree.createTree();

       // Node root =tree.f1(1);
        System.out.print("InOrder : ");
        tree.inorder(root);

        System.out.println();
        System.out.print("PreOrder :");
        tree.preOrder(root);

        System.out.println();
        System.out.print("PostOrder :");
        tree.postOrder(root);
    }

    void postOrder(Node root) {
        //L_R_Ro
        if(root==null){
            return;
        }
        if(root.left != null){
            postOrder(root.left);
        }
        if (root.right != null){
            postOrder(root.right);
        }
        System.out.print(root.data+" ");
    }

    void preOrder(Node root){
        //Ro_L_R
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        if(root.left!= null){
             preOrder(root.left);
        }
        if(root.right!=null){
             preOrder(root.right);
        }
    }

    private void inorder(Node root) {
        //L_Ro_R
        if(root==null){
            return;
        }
        if(root.left != null ){
            inorder(root.left);
        }
        System.out.print(root.data + " ");
        if(root.right != null){
            inorder(root.right);
        }
    }
    Node fun2(Node root){
        if(root.left !=null){
          Node x =  fun4(root.left);
            System.out.print(x.data + " ");
        }
        if(root.right != null){
            Node y = fun5(root.right);
            System.out.print(y.data + " ");
        }
        System.out.print(root.data + " ");
        return root;
    }
    Node fun4(Node root){
        if(root.left== null && root.right== null){
            return root;
        }
        return null;
    }
    Node fun5(Node root){
        if(root.left== null && root.right== null){
            return root;
        }
        return null;
    }

    Node createTree(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        return root;
    }
    Node f1(int data){
        if(data== 4){
            return new Node(4);
        }
        else if(data== 5){
            return new Node(5);
        }
        else if(data== 6){
            return new Node(6);
        }
        else if(data== 7){
            return new Node(7);
        }
        Node newNode = new Node(data);
        newNode.left = f1(data+data);
        newNode.right = f1 (data+data+1);
        return newNode;
    }
//    Node f2(int data){
//        Node newNode = new Node(data);
//        data++;
//        newNode.prev = f4(data+1);
//        newNode.next = f5(data+2);
//        return newNode;
//    }
//    Node f3(int data){
//        Node newNode = new Node(data);
//        data++;
//        data++;
//        newNode.prev = f6(data+1);
//        newNode.next = f7(data+2);
//        return newNode;
//    }
//    Node f4(int data){
//        Node newNode = new Node(data);
//        return newNode;
//    }
//    Node f5(int data){
//        Node newNode = new Node(data);
//        return newNode;
//    }
//    Node f6(int data){
//        Node newNode = new Node(data);
//        return newNode;
//    }
//    Node f7(int data){
//        Node newNode = new Node(data);
//        return newNode;
//    }
}
