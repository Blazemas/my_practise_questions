public class Linkedlist {

    public static class Node{

        int data;
        Node next;

        public Node(int val){
            this.data = val;
            this.next = null;
        }
    }
    public static Node head;
    public static Node Tail;
    public static int size;  //to keep track of size of LL always increment when newnode is created or added in LL

    public void addfirst(int val){ //Adding new node at head
        //creating new node
        Node newnode = new Node(val);
        size++;  //to keep track of size of LL
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
    public void addlast(int val){ //Adding new node at Tail
        //creating new node
        Node newnode = new Node(val);
        size++;//to keep track of size of LL
        //if Linkedlist is already empty
        if(head == null){
            head = newnode;
            Tail = newnode;
            return;
        }
        //pointing Tail's next to newnode
        Tail.next = newnode;
        //pointing Tail to newnode
        Tail = newnode;

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
    public void addAtindex(int idx,int val){

        Node curr = head;
        if(idx == 0){
            addfirst(val);
            return;
        }
        Node newnode = new Node(val);
        size++;   //to keep track of size of LL
        int i=0;
        while(i < idx-1){
            curr = curr.next;
            i++;
        }
        newnode.next = curr.next;
        curr.next = newnode;
    }
    public int removefirst(){

        if(head == null || size == 0){
            System.out.println("sorry LL is already empty");
            return 0;
        }
        else if(size == 1){
            int val = head.data;  //before deleting we store that data in val variable
            head = Tail = null;
            size = 0;     //updating the size of LL 
            return val;
        }
        int val = head.data;  //before deleting we store that data in val variable
        head = head.next;
        size--;  //updating the size of LL 
        return val;
    }
    public int removelast(){

//Note - return type can be void also, but here we are storing the value before deleting in val therefore Int
//NOte - for void as return type don't store data of before deleting.
        if(head == null || size == 0){
            System.out.println("sorry LL is already empty");
            return 0;
        }
        if(size == 1){
            int val = head.data;
            head = Tail = null;
            size = 0;
            return val;
        }
        //traversing up to size -2 (2nd last node)
        Node prev = head;
        for(int i=0;i<size-2;i++){
            prev = prev.next;
        }
        int val = Tail.data; // or val = prev.next.data
        Tail = prev;
        prev.next = null;
        size--;
        return val;
    }
    public int iterativeSearch(int key){

        int i = 0;
        Node curr = head;
        while(curr != null){
            //check if key exists
            if(curr.data == key){
                return i;  //return index of key if found
            }
            curr = curr.next;
            i++;
        }
        //key not found
        return -1;
    }
    public int recursiveSearch(int st_idx,int key,Node curr){  //O(n)

        if(curr == null){   
            return -1;
        }
        if(curr.data == key){
            return st_idx;
        }
        return recursiveSearch(st_idx+1,key,curr.next);
    }
    public void reverseLL(){

        Node prev = null;
        Node curr = Tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public void removelast_nth(int n){  //find and delete the nth node from end

        Node prev = head;

        if(n == size){   //deleting the head
            head = head.next;
            return;
        }
        int i=1;
        int prev_idx = size - n;
        while(i < prev_idx){

            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
    }
    //code to find the middle node for LL
    public Node middlenode(Node head){

        Node slow = head;  //turtle 
        Node fast = head;   //hare

        while(fast !=null && fast.next !=null){
            slow = slow.next;  //jump by 1 node
            fast = fast.next.next;  //jump by 2 node
        }
        return slow; //middle node of LL
    }
    public boolean palindrome_LL(){
  
        //base condition
        if(head == null || head.next == null ){
            return true;
        }
        //step 1 - find middle node
        Node mid_node = middlenode(head);

        //step 2 - reverse the 2nd half LL

        Node prev = null;
        Node curr = mid_node;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;  //right half LL's head
        Node left = head;
 
        //step 3 - check if left half = right half
        while(right != null){

            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;

        }
        return true;
    }
       public boolean iscycle_in_LL(){
        Node slow = head;
        Node fast = head;

        while(fast != null || fast.next != null){

            slow = slow.next;  //jump node by 1
            fast = fast.next.next; //jump node by 2

            if(slow == fast){  //check if cycle exists
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]){

        Linkedlist L1 = new Linkedlist();
        // L1.head = new Node(1);
        // L1.head.next = new Node(4);
        L1.addfirst(9);
        L1.addfirst(10);
        L1.addfirst(6);
        L1.addfirst(3);
        L1.addlast(18);
        L1.addlast(11);
        //crating new Node curr to traverse the Linkedlist
        L1.printLL();
        L1.addAtindex(3, 99);
        L1.addAtindex(0, 100);
        //System.out.println("size: "+L1.size);
        L1.printLL();
        L1.removefirst();
        L1.removefirst();
        L1.printLL();
        System.out.println(size);
        L1.removelast();
        L1.printLL();
        //System.out.println(size);
        System.out.println(L1.iterativeSearch(99));
        System.out.println(L1.iterativeSearch(67));
        Node curr = head;
        System.out.println(L1.recursiveSearch(0,99,curr));
        System.out.println(L1.recursiveSearch(0,67,curr));
        //L1.printLL();
        //L1.reverseLL();
        L1.printLL();
        L1.removefirst();
        L1.removefirst();
        L1.removefirst();
        L1.removefirst();
        L1.removefirst();
        //L1.removelast_nth(2);
        L1.printLL();
        L1.addfirst(1);
        L1.addfirst(2);
        L1.addfirst(3);
        // L1.addfirst(3);
        // L1.addfirst(2);
        // L1.addfirst(1);
        // L1.printLL();  //1->2->3->3->2->1
        // System.out.println(L1.palindrome_LL());
        

    }
    
}
