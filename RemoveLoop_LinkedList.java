public class RemoveLoop_LinkedList {
    class Node{
        int data;
        Node next = null;
        Node(int data){
            this.data= data;
        }
    }
    public static void main(String[] args) {
        RemoveLoop_LinkedList linkedList = new RemoveLoop_LinkedList();
        Node head = linkedList.createLinkedlist();

        Node detectLoopNode = linkedList.detectAndRemoveLoop(head);
        linkedList.printList(detectLoopNode);
    }

    private Node detectAndRemoveLoop(Node head) {
        Node slow_ptr = head.next;
        Node fast_ptr = head.next.next;
        while (fast_ptr != slow_ptr){
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }
        Node node = slow_ptr.next;
        System.out.println("loop present in node " + slow_ptr.data);

        System.out.print(slow_ptr.data + " ");
        while (node.data != slow_ptr.data){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.print(node.data + " ");
        System.out.println();
        slow_ptr.next.next = null;
        return head ;
    }

    private Node createLinkedlist() {
        Node head = new Node(10);
        head.next = new Node(11);
        head.next.next = new Node(13);
        head.next.next.next = new Node(17);
        head.next.next.next.next = new Node(19);
        head.next.next.next.next.next = new Node(22);

        head.next.next.next.next.next = head.next.next;
        return head ;
    }

    void printList(Node head){
        while (head!=null){
            System.out.print(head.data +" ");
            head = head.next;
        }
        System.out.println();
    }
}
