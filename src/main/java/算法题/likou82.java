package 算法题;

public class likou82 {
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int x){
            this.val=x;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        if (head.val==head.next.val){
            while(head.next!=null&&head.val==head.next.val){
                head=head.next;
            }
            return deleteDuplicates(head.next);
        }else{
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}
