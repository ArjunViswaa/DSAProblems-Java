package LinkedList;

public class Remove_Dups_from_SortedList {
	static class ListNode {
		public int val;
		public ListNode next;
		ListNode(int X) {
			val = X; next = null;
		}
	}
	
	public static ListNode deleteDuplicates(ListNode A) {
        ListNode temp = A;
        while(temp.next != null) {
            if(temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return A;
    }
	
	public static void main(String[] args) {
		ListNode A = new ListNode(10);
		ListNode B = new ListNode(20); A.next = B;
		ListNode C = new ListNode(30); B.next = C;
		ListNode D = new ListNode(30); C.next = D;
		ListNode E = new ListNode(50); D.next = E;
		ListNode temp = deleteDuplicates(A);
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}
}
