public class Merge2LinkedList {
    class  Node{
        int data;
        Node next = null;
        Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Merge2LinkedList list = new Merge2LinkedList();
        Node leftNode = list.createLinkedList1();
        Node rightNode = list.createLinkedList2();

        System.out.println("Left node..");
        list.displayLinedlist(leftNode);
       // Node head = list.InsertNode(100,leftNode);
        System.out.println("Right node..");
        list.displayLinedlist(rightNode);

        Node resNode = list.mergeList_Method2(leftNode,rightNode);
                      //list.mergeList(leftNode,rightNode);
        System.out.println("Result node..");
        list.displayLinedlist(resNode);
    }

    private Node mergeList(Node leftNode, Node rightNode) {
        Node result = null;
        while (leftNode!=null && rightNode != null){
            if(leftNode.data<rightNode.data){
                result = insertNode(leftNode.data, result);
                leftNode= leftNode.next;
            }
            else{
                result = insertNode(rightNode.data, result);
                rightNode = rightNode.next;
            }
        }
        if (leftNode!= null){
            result = insertNode(leftNode.data, result);
            leftNode = leftNode.next;
        }
        else if (rightNode!=null){
            result = insertNode(rightNode.data,result);
            rightNode = rightNode.next;
        }
        return result;
    }

    private Node insertNode(int data,Node head){
        if(head == null){
            return new Node(data);
        }
        Node current = head;
        while (current.next != null){
            current = current.next;
        }
        Node newNode = new Node(data);
        current.next = newNode;
        return head;
    }

    private Node mergeList_Method2(Node leftNode, Node rightNode){
        Node result = null;
        if(leftNode.data<rightNode.data){
            result = leftNode;
            leftNode= leftNode.next;
            result = method_Left(result,leftNode,rightNode);
        }
        else{
            result = rightNode;
            rightNode = rightNode.next;
            result = method_Right(result,leftNode,rightNode);
        }
        return result;
    }
    private Node method_Right(Node result, Node leftNode, Node rightNode){
        while (leftNode != null && rightNode != null) {
            if (leftNode.data < rightNode.data) {
                Node node = leftNode;
                leftNode = leftNode.next;
                node.next = null;
                result = insertNodeInBetween(node, result);
            }
            else {
                rightNode = rightNode.next;
            }
        }
        if (leftNode!=null){
            result = insertAtLast(leftNode, result);
        }
        return result;
    }
    private Node method_Left(Node result, Node leftNode, Node rightNode){
        while (leftNode != null && rightNode != null) {
            if (rightNode.data < leftNode.data) {
                Node node = rightNode;
                rightNode = rightNode.next;
                node.next = null;
                result = insertNodeInBetween(node, result);
            }
            else {
                leftNode = leftNode.next;
            }
        }
        if (rightNode!=null){
            result = insertAtLast(rightNode, result);
        }
        return result;
    }
    private Node insertNodeInBetween(Node insertedNode, Node head){
        Node current = head.next;
        Node prev = head;
        while(current!=null && current.data<insertedNode.data){
            current = current.next;
            prev = prev.next;
        }
        prev.next = insertedNode;
        insertedNode.next = current;
        return head;
    }
    private Node insertAtLast(Node insertedNode,Node result){
        Node current = result;
        while (current.next != null){
            current = current.next;
        }
        current.next = insertedNode;
        return result;
    }
    private void displayLinedlist(Node node) {
        while (node!= null){
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println();
    }
    private Node createLinkedList1() {
        Node head = new Node(2);
        head.next = new Node(5);
        head.next.next= new Node(10);
        head.next.next.next = new Node(14);
        head.next.next.next.next= new Node(16);
        return head;
    }
    private Node createLinkedList2() {
        Node head = new Node(3);
        head.next = new Node(7);
        head.next.next= new Node(9);
        head.next.next.next = new Node(15);
        //head.next.next.next.next= new Node(25);
        return head;
    }
}
