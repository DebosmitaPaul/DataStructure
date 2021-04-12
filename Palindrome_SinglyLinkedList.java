import java.util.Stack;

public class Palindrome_SinglyLinkedList {
    class  Node{
        int data;
        Node next = null;
        Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Palindrome_SinglyLinkedList list = new Palindrome_SinglyLinkedList();
        Node head = list.createLinkedList();
        list.displayList(head);

        boolean isPalindrome = list.isListPalindrome(head);
        System.out.println(isPalindrome);
    }

    private boolean isListPalindrome(Node head) {
        Node current = head;
        Stack<Integer> stack = new Stack<Integer>();
        while (current!=null){
            stack.push(current.data);
            current = current.next;
        }
        while (head!= null){
            if(head.data != stack.pop()){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    private void displayList(Node head) {
        while(head!=null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    private Node createLinkedList() {
        Node head = new Node(2);
        head.next = new Node(5);
        head.next.next= new Node(4);
        head.next.next.next = new Node(5);
        head.next.next.next.next= new Node(2);
        return head;
    }
}
