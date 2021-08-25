// Recursion
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        } else {
            ListNode second = head.next;
            ListNode headNext = swapPairs(second.next);
            second.next = head;
            head.next = headNext;
            return second;
        }
    }    
}

// Iteration
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode prev = null;
        ListNode temp = head;
        head = head.next;
        
        while (temp != null && temp.next != null) {
            ListNode node = temp.next;
            temp.next = node.next;
            node.next = temp;
            if (prev != null) {
                prev.next = node;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
}
