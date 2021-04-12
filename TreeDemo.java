class Node{
    int data;
    Node left;
    Node right;
}
public class TreeDemo {
    public static void main(String[] args) {
        TreeDemo td = new TreeDemo();
        Node node = td.f1(1);
        td.print_f1(node);
    }
    Node f1(int data){
        Node node = new Node();
        node.data = data;
        node.left = new Node();
        node.left.data = 2;
        node.right = new Node();
        node.right.data =3;
        node.left.left = new Node();
        node.left.left.data=4;
        node.left.right = new Node();
        node.left.right.data = 5;
        return node;
    }
//    Node f2(){
//        Node node = new Node();
//        node.data = 2;
//        Node nextNode1 = f4();
//        Node nextNode2 = f5();
//        node.left = nextNode1;
//        node.right = nextNode2;
//        return node;
//    }
//    Node f3(){
//        Node node = new Node();
//        node.data = 3;
//        node.left = null;
//        node.right = null;
//        return node;
//    }
//    Node f4(){
//        Node node = new Node();
//        node.data = 4;
//        node.left = null;
//        node.right = null;
//        return node;
//    }
//    Node f5(){
//        Node node = new Node();
//        node.data = 5;
//        node.left = null;
//        node.right = null;
//        return node;
//    }
    void print_f1(Node f1){
        if(f1 != null){
            System.out.println(f1.data);
            print_f1(f1.left);
            print_f1(f1.right);
        }
    }
//    void print_f2(Node f2){
//        System.out.println(f2.data);
//        print_f4(f2.left);
//        print_f3(f2.right);
//    }
//    void print_f3(Node f3){
//        System.out.println(f3.data);
//    }
//    void print_f4(Node f4){
//        System.out.println(f4.data);
//    }
//    void print_f5(Node f5){
//        System.out.println(f5.data);
//    }
}
