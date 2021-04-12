public class LinkedListDemo {
    class  Node{
        int data;
        Node next = null;
    }
    Node createLinkedList(){
        LinkedListDemo linkedList = new LinkedListDemo();
        Node head = linkedList.pushData(11, null);
        Node nextNode1 = linkedList.pushData(17, head);
        Node nextNode2 = linkedList.pushData(19, nextNode1);
        Node nextNode3 = linkedList.pushData(23, nextNode2);
        Node nextNode4 = linkedList.pushData(25, nextNode3);
        Node nextNode5 = linkedList.pushData(29, nextNode4);

        return head;
    }
    public static void main(String[] args) {
        LinkedListDemo linkedList = new LinkedListDemo();
        //Node node = linkedList.f1(1);
        Node head = linkedList.createLinkedList();
        linkedList.printList(head);
        System.out.println("------------------");

        Node reverseNode = linkedList.reverseLinedlist(head);
        System.out.println("Reverse :");
        linkedList.printList(reverseNode);
        System.out.println("------------------");

        head = reverseNode;
        Node node_del_last= linkedList.deleteNodeFromLast(head);
        System.out.println("delete last node :");
        linkedList.printList(node_del_last);
        System.out.println("------------------");

        Node node_del_1st = linkedList.deleteNodeFromFirst(head);
        System.out.println("delete first node :");
        linkedList.printList(node_del_1st);
        System.out.println("------------------");

        head = node_del_1st;
        Node node_delNode= linkedList.deleteANode( 19, head);
        System.out.println("delete 19 element :");
        linkedList.printList(node_delNode);
        System.out.println("------------------");

    }
    Node reverseLinedlist(Node node){
        Node head = node;
        Node prevNode = node;
        node = node.next;
        prevNode.next = null;

        while (node.next!=null){
            Node nextNode = node.next;
            node.next = prevNode;
            prevNode = node;
            node = nextNode;
        }

        return prevNode;
    }
    Node deleteNodeFromFirst( Node node) {
        Node prevNode = node.next;
        node.next = null;
        return prevNode;
    }
    Node deleteNodeFromLast( Node node) {
        Node head = node;
        Node prevNode = null;
        while(node.next!=null){
            prevNode = node;
            node = node.next;
        }
        prevNode.next = null;
        return head;
    }
    Node deleteANode(int data, Node node){
        Node head = node;
        Node prevNode = null;
        while(node.data!= data){
            prevNode = node;
            node = node.next;
        }
        prevNode.next = node.next;
        node.next = null;
        return head;
    }
    void printList(Node node){
        while (node!= null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
    Node pushData(int data, Node nextNode){
        Node node = new Node();
        node.data = data;
        if(nextNode != null) {
            nextNode.next = node;
        }
        return node;
    }
    Node f1(int data){
        Node node = new Node();
        node.data = data;
        if (node.data ==3){
            node.next = null;
            return node;
        }
        node.next = f1(data+1);
        return node;
    }
//    Node f2(int data){
//        Node node = new Node();
//        node.data = data;
//        node.next = f3(data+1);
//        return node;
//    }
//    Node f3(int data){
//        Node node = new Node();
//        node.data = data;
//        node.next = null;
//        return node;
//    }
}
