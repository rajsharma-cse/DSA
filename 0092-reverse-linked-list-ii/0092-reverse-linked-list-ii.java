/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null) return null;
        if (left == right) return head;
        ListNode temp=head;
        int count=1;
        ListNode before=null;
        while(temp!=null){
            if(count < left){
                before=temp;
                count++;
                temp=temp.next;
            }else{
                // ListNode x=temp;
                ListNode cur=temp;
                ListNode prev=null;
                int time=right-left+1;
                while(time-- >0){
                    ListNode next=cur.next;
                    cur.next=prev;
                    prev=cur;
                    cur=next;
                }
                temp.next=cur;
                if(before==null)
                    return prev;
                before.next=prev;
                break;
            }
        }
        return head;
    }
}