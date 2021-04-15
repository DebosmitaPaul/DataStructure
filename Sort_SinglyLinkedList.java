public class Sort_SinglyLinkedList {
    class  Node {
        int data;
        Node next = null;

        Node(int data) {
            this.data = data;
        }
    }
    public static void main(String[] args) {
        Sort_SinglyLinkedList list = new Sort_SinglyLinkedList();
        Node head = list.createLinkedList();
        System.out.println("before sort");
        list.displayList(head);

        Node node = list.sortLinkedList(head);
        System.out.println("after sort");
        list.displayList(node);
    }

    private Node sortLinkedList(Node head) {
        if(head == null || head.next==null){
            return head;
        }
        Node midNode = getMiddelNode(head);
        Node nextOfMid = midNode.next;
        midNode.next = null;
        Node leftNode = sortLinkedList(head);
        Node rightNode = sortLinkedList(nextOfMid);
        Node n = sortNodes(leftNode,rightNode);
        return n;
    }
    private Node sortNodes(Node leftNode, Node rightNode) {
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

    private Node insertNode(int data, Node head){
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

    private Node getMiddelNode(Node head) {
        Node slow_ptr = head;
        Node fast_ptr = head;
        while (fast_ptr.next!=null && fast_ptr.next.next!= null){
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }
        return slow_ptr;
    }

    private void displayList(Node head) {
        while(head!=null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    private Node createLinkedList() {
        Node head = new Node(9);
        head.next = new Node(5);
        head.next.next = new Node(4);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(8);
        return head;
    }
}
