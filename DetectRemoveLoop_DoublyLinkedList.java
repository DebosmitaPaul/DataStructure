public class DetectRemoveLoop_DoublyLinkedList {
    class Node {
        int data;
        Node prev = null;
        Node next = null;
        Node(int data) {
            this.data = data;
        }
    }
    public static void main(String[] args) {
        DetectRemoveLoop_DoublyLinkedList linkList = new DetectRemoveLoop_DoublyLinkedList();
        Node head = linkList.createDoublyLinkList();
        while (head.prev!= null){
            head = head.prev;
        }
        linkList.displayDoublyLinkedList(head);

        linkList.detectAndRemoveLoop(head);
        linkList.displayDoublyLinkedList(head);
        
        linkList.deleteANode(13, head);
        linkList.displayDoublyLinkedList(head);
    }

    private void detectAndRemoveLoop(Node head) {
    }

    private void deleteANode(int x, Node head) {
        while (head.data != x){
            head = head.next;
        }
        head.prev.next = head.next;
        head.next.prev = head.prev;
        head.next = null;
        head.prev = null;
    }

    Node pushData(int data, Node prevNode) {
        Node node = new Node(data);
        if(prevNode != null) {
            node.prev = prevNode;
            prevNode.next = node;
        }
        return node;
    }
    private void displayDoublyLinkedList(Node head) {
        //forward
        System.out.println("Forward...");
        while (head.next!=null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.print(head.data + " ");
        System.out.println();

        //backward
        System.out.println("Beackward...");
        while (head!=null){
            System.out.print(head.data + " ");
            head= head.prev;
        }
        System.out.println();
    }

    private Node createDoublyLinkList() {
        Node head = pushData(10, null);
        head = pushData(11, head );
        head = pushData(13, head );
        head = pushData(17, head );
        head = pushData(18, head );

        return head;
    }
}
