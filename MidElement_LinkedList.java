public class MidElement_LinkedList {
    class  Node{
        int data;
        Node next = null;
    }
    public static void main(String[] args) {
        MidElement_LinkedList linkedList = new MidElement_LinkedList();
        Node head = linkedList.createLinkedList();
        System.out.println("Print my linkedlist..");
        linkedList.printList(head);

        int midNodeData = linkedList.findMidNode(head);
        System.out.println("Mid element in linkedlist.." + midNodeData);

        head = linkedList.deleteMidElement(midNodeData,head);
        System.out.println("After deletion my linkedlist is..");
        linkedList.printList(head);
    }

    private Node deleteMidElement(int midNodeData, Node head) {
        Node node = head;
        Node prevNode = null;
        while (node.data != midNodeData){
            prevNode = node;
            node = node.next;
        }
        prevNode.next = node.next;
        node.next = null;
        return head;
    }

    int findMidNode(Node head){
        Node slow_ptr = head;
        Node fast_ptr = head;
        while(fast_ptr.next!=null && fast_ptr.next.next!=null){
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }
        return slow_ptr.data;
    }
    Node createLinkedList(){
        MidElement_LinkedList linkedList = new MidElement_LinkedList();
        Node head = linkedList.pushData(11, null);
        Node nextNode1 = linkedList.pushData(17, head);
        Node nextNode2 = linkedList.pushData(19, nextNode1);
        Node nextNode3 = linkedList.pushData(23, nextNode2);
        Node nextNode4 = linkedList.pushData(25, nextNode3);
        Node nextNode5 = linkedList.pushData(29, nextNode4);

        return head;
    }
    Node pushData(int data, Node nextNode){
        Node node = new Node();
        node.data = data;
        if(nextNode!= null){
            nextNode.next =node;
        }
        return node;
    }
    void printList(Node head){
        while (head!=null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}