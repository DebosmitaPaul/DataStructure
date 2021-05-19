/*
Input: head = [1,2,2,1]
Output: true

Input: head = [1,2]
Output: false

 */

public class Palindrome_LinkedList {
    static class ListNode{
        int data;
        ListNode next = null;
        ListNode(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        ListNode head = createLinkedList();
        System.out.println(isPalindrome(head));
    }
    public static boolean isPalindrome(ListNode head) {
        if(head.next == null || (head.next.next == null && head.data == head.next.data)){
            return true;
        }
        if(head.next.next == null){
            return false;
        }
        ListNode prev_midNode = getPrevMidNode(head);
        ListNode secondHalf_Head = prev_midNode.next;
        prev_midNode.next = null;
        secondHalf_Head = reverse(secondHalf_Head);

        return isIdentical(head, secondHalf_Head);
    }

    private static boolean isIdentical(ListNode head, ListNode secondHalf_head) {
        while(head!= null && secondHalf_head!=null){
            if(head.data == secondHalf_head.data) {
                head = head.next;
                secondHalf_head = secondHalf_head.next;
            }else {
                return false;
            }
        }
        return true;
    }

    private static ListNode reverse(ListNode head) {
        if(head.next==null || head == null){
           return head;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        prev.next = null;
        while(curr!= null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr= nextNode;
        }
        return prev;
    }

    private static ListNode getPrevMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast.next!=null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode createLinkedList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next= new ListNode(2);
        head.next.next.next = new ListNode(1);
        return head;
    }

}
