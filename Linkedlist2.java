import java.util.LinkedList;
public class Linkedlist2 {

    public class Node{

        int data;
        Node next;
        
        public Node(int val){
            this.data = val;
            this.next = null;
        }
    }
    public static Node head;
    public static Node Tail;

    public static boolean iscycle_in_LL(){
        Node slow = head;
        Node fast = head;

        while(fast != null){

            slow = slow.next;  //jump node by 1
            fast = fast.next.next; //jump node by 2

            if(slow == fast){  //check if cycle exists
                return true;
            }
        }
        return false;
    }
   
    public void remove_cycle(){

        //step 1 - detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;
            if(slow ==fast){
                cycle = true;
                return;
            }
        }
        if(cycle == false){
            return ;
        }
        //step 2 - find the meeting point 
        slow = head;
        Node prev = null;   //prev to find the node where cycle formed
        while(slow != fast){

            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        //step 3 - break the cycle by making prev.next to nulls
        prev.next = null;  
    }
    public Node merge(Node head1, Node head2){


        Node mergeLL = new Node(-1);  //dummy node for temporary LL
        Node temp = mergeLL;

        while(head1 != null && head2 != null){

            if(head1.data <= head2.data){

                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head1.next;
            temp = temp.next;

        }
        return mergeLL.next;

    }
    public Node mergesort(Node head){

        if(head == null || head.next == null){
            return head;
        }
         //find mid node
        Node Midnode = midnode(head);

        LinkedList<Integer> MergedLL = new LinkedList<>();
        //left and right mergesort
        Node righthead = Midnode.next;
        Midnode.next = null;
        Node newleft = mergesort(head);
        Node newright = mergesort(righthead);

        return merge(newleft,newright);
    }
    public void addfirst(int val){ //Adding new node at head
        //creating new node
        Node newnode = new Node(val);
        // size++;  //to keep track of size of LL
        //if Linkedlist is already empty
        if(head == null){
            head = newnode;
            Tail = newnode;
            return;
        }
        //pointing newnode's next to head
        newnode.next = head;
        //pointing head to newnode
        head = newnode;

    }
    public void printLL(){

        Node curr = head;
        while(curr != null){
            System.out.print(curr.data+"->");
            curr = curr.next;
        }
        System.out.print("NULL");
        System.out.println();
    }

    // IMP Question for coding .

    // Zig Zac linked list.

    public Node midnode(Node head){

        Node slow = head;
        Node fast = head.next;  //to get the last node as midnode for 1st LL

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;  //midnode is last node of 1st LL
    }

    public void zigzacLL(Node head){

        //step 1 - find the midnode
        Node Midnode = midnode(head);
        
        //step 2 - divide the linkedlist 
        Node curr = Midnode.next;
        Midnode.next = null;

        //step 3 - reverse the 2nd LL

        Node prev = null;
        Node next;

        while(curr !=null){

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node lefthead = head;
        Node righthead = prev;

        //step 4 - alternate merging
        Node nextL , nextR;
        while(lefthead != null && righthead != null){
 
            //linking 
            nextL = lefthead.next;
            lefthead.next = righthead;
            nextR = righthead.next;
            righthead.next = nextL;

            //updating left and right head 
            lefthead = nextL;  
            righthead = nextR;
        }
    }

    public static void main(String args[]){

     
        // Linkedlist from Java collection framework
        //LL of JCF are well optimized and uses/has only object.
        //hence we have to use classes like Integer,Boolean,Float,Character
        Linkedlist2 L1 = new Linkedlist2();
        // L1.addfirst(1);
        // L1.addfirst(4);
        // L1.addfirst(7);
        // L1.addfirst(12);

        // L1.printLL();
        // L1.head = L1.mergesort(L1.head);
        // L1.printLL();

        L1.addfirst(6);
        L1.addfirst(5);
        L1.addfirst(4);
        L1.addfirst(3);
        L1.addfirst(2);
        L1.addfirst(1);
        L1.printLL();

        L1.zigzacLL(head);
        L1.printLL();

    }
    
}
