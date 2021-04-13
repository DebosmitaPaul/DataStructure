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
        System.out.println("Left node..");
        list.displayLinedlist(leftNode);
       // Node head = list.InsertNode(100,leftNode);
        Node rightNode = list.createLinkedList2();
        System.out.println("Right node..");
        list.displayLinedlist(rightNode);

        Node resNode =  list.mergeList(leftNode,rightNode);
        System.out.println("Result node..");
        list.displayLinedlist(resNode);
    }

    private void displayLinedlist(Node node) {
        while (node!= null){
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println();
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
        while (leftNode!= null){
            result = insertNode(leftNode.data, result);
            leftNode = leftNode.next;
        }
        while (rightNode!=null){
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

    private Node createLinkedList1() {
        Node head = new Node(2);
        head.next = new Node(5);
        head.next.next= new Node(10);
        head.next.next.next = new Node(14);
        head.next.next.next.next= new Node(16);
        return head;
    }
    private Node createLinkedList2() {
        Node head = new Node(1);
        head.next = new Node(7);
        head.next.next= new Node(9);
        head.next.next.next = new Node(15);
        head.next.next.next.next= new Node(25);
        return head;
    }
}
