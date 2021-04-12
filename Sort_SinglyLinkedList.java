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

        Node node = list.sortLinkedList(head);
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
         return head;
    }
    Node sortNodes(Node a, Node b){
        if(a==null){
            return b;
        }
        if (b==null){
            return a;
        }
        if(a.data>b.data){
            //Node temp = a.next;
            a.next = b.next;
            b.next = null;
        }
        return a;
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
