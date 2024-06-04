package LinkedList;

public class ReverseLinkedList {
	static class ListNode {
		public int val;
		public ListNode next;
		ListNode(int X) {
			val = X; next = null;
		}
	}
	
	public static ListNode reverse(ListNode A) {
		ListNode prev = null;
		ListNode curr = A;
		while(curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	public static void main(String[] args) {
		ListNode A = new ListNode(10);
		ListNode B = new ListNode(20); A.next = B;
		ListNode C = new ListNode(30); B.next = C;
		ListNode D = new ListNode(40); C.next = D;
		ListNode E = new ListNode(50); D.next = E;
		ListNode temp = reverse(A);
		while(temp != null) {
			System.out.print(temp.val +" ");
			temp = temp.next;
		}
	}
}
