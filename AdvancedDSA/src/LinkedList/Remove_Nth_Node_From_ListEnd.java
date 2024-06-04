package LinkedList;

public class Remove_Nth_Node_From_ListEnd {
	static class ListNode {
		public int val;
		public ListNode next;
		ListNode(int X) {
			val = X; next = null;
		}
	}
	
	public static ListNode removeNthFromEnd(ListNode A, int B) {
        int len = 0;
        ListNode temp = A;
        while(temp != null) {
            len++;
            temp = temp.next;
        }
        temp = A;
        if(len <= B) {
            return A.next;
        }
        for(int i=0; i<(len - B - 1); i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return A;
    }
	
	public static void main(String[] args) {
		ListNode A = new ListNode(10);
		ListNode B = new ListNode(20); A.next = B;
		ListNode C = new ListNode(30); B.next = C;
		ListNode D = new ListNode(40); C.next = D;
		ListNode E = new ListNode(50); D.next = E;
		ListNode temp = removeNthFromEnd(A, 3);
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}
}
