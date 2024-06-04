package LinkedList;

public class Check_Pallindrome_LL {
	static class ListNode {
		public int val;
		public ListNode next;
		ListNode(int X) {
			val = X; next = null;
		}
	}
	public static int lPalin(ListNode A) {
        int len = 0;
        ListNode temp = A;
        while(temp != null) {
            len++;
            temp = temp.next;
        }
        len /= 2;
        temp = A;
        for(int i=1; i<len; i++) {
            temp = temp.next;
        }
        ListNode A2 = temp.next;
        temp.next = null;
        temp = A;
        ListNode temp2 = A2;
        temp2 = reverse(temp2);
        while(temp != null && temp2 != null) {
            if(temp.val != temp2.val) {
                return 0;
            }
            temp = temp.next;
            temp2 = temp2.next;
        }
        return 1;
    }
	
	public static void main(String[] args) {
		ListNode A = new ListNode(10);
		ListNode B = new ListNode(20); A.next = B;
		ListNode C = new ListNode(30); B.next = C;
		ListNode D = new ListNode(20); C.next = D;
		ListNode E = new ListNode(10); D.next = E;
		System.out.print(lPalin(A));
	}

    private static ListNode reverse(ListNode A) {
        ListNode curr = A;
        ListNode prev = null;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
