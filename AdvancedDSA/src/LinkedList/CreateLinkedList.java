package LinkedList;

public class CreateLinkedList {
	static class Node {
        int val;
        Node next;
        Node(int x) {
            this.val = x;
            this.next = null;
        }
    }
	
	public static Node head = null;

    public static void insert_node(int position, int value) {
        if(head == null) {
            head = new Node(value);
            return;
        } else {
            Node nn = new Node(value);
            Node temp = head;
            if(position == 1) {
                head = nn;
                head.next = temp;
                return;
            }
            for(int i=1; i<position-1; i++) {
                temp = temp.next;
            }
            nn.next = temp.next;
            temp.next = nn;
        }
        return;
    }
    
    public static void delete_node(int position) {
        if(position == 1) {
            head = head.next;
            return;
        }
        Node temp = head;
        for(int i=1; i<position-1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public static void print_ll() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
    
    public static void main(String[] args) {
    	insert_node(1, 10);
    	insert_node(2, 20);
    	insert_node(3, 30);
    	insert_node(4, 40);
    	insert_node(5, 50);
    	delete_node(4);
    	print_ll();
    }
}
