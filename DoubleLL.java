public class DoubleLL {

    public static class Node{

        int data;
        Node next;
        Node prev;

        public Node(int val){

            this.data = val;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node Tail;
    public static int size;
    
    public void addfirst(int val){

        Node newnode = new Node(val);
        if(head == null){
            head = Tail = newnode;
            size ++;
            return;
        }
        newnode.next = head;
        head.prev = newnode;
        head = newnode;
        size++;
    }
    public void addlast(int val){

        Node newnode = new Node(val);
        if(head == null){
            head = Tail = newnode;
            size ++;
            return;
        }
        Tail.next = newnode;
        newnode.prev = Tail;
        Tail = Tail.next;
        size++;
    }
    public void printDLL(){

        if(head == null){
            System.out.println("DDl is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public int removefirst(){

        if(head == null){
            System.out.println("DDL is empty");
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            int val = head.data;
            head = Tail = null;
            size--;
            return val;
        }
        int val = head.data;
        //head.next = null;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }
    public int removelast(){

        if(head == null){
            System.out.println("DDL is empty");
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            int val = head.data;
            head = Tail = null;
            size--;
            return val;
        }
        int val = Tail.data;
        Tail = Tail.prev;
        Tail.next = null;
        size--;
        return val;
    }
    public void reverseddl(){

        if(head == null){
            return;
        }
        Node curr = head;
        Node prev_1 = null;  //extra prev to do revesing
        Node next;

        while(curr != null){

            //reversing
            next = curr.next;
            curr.next = prev_1;
            curr.prev = next;

            //updating curr and prev (incrementing to reverse each node)
            prev_1 = curr;
            curr = next;
        }
        head = prev_1;
    }
    public void make_circularddl(){

        if(head == null){
            return;
        }
        head.prev = Tail;
        Tail.next = head;
    }
    public void print_circularddl(){

        if(head == null){
            System.out.println("ddl is empty");
            return;
        }
        Node temp = head;
        int turn = 0;
        while(turn != 4){
            System.out.print(temp.data + "<->");
            temp = temp.next;
            turn++;
        }
        System.out.print("null");
        System.out.println();
    
    }

    public static void main(String args[]){

        DoubleLL ddl = new DoubleLL();
        ddl.addfirst(1);
        ddl.addfirst(2);
        ddl.addlast(3);
        ddl.addlast(4);
        ddl.printDLL();

        System.out.println(ddl.size);
        ddl.reverseddl();
        ddl.printDLL();
        ddl.make_circularddl();
        //ddl.printDLL();
        ddl.print_circularddl();

    }
    
}
