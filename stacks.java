import java.util.*;
import java.util.ArrayList;
public class stacks{

    //class stackA -  implementaion of stack using ArrayList
    static class stackA{
       
        static ArrayList<Integer> list = new ArrayList<>();

        // checking if stack is empty
        public static boolean isempty(){

            if(list.size() == 0){
                return true;
            }
            else{
                return false;
            }
        }
        //push
        public static void push(int val){

            list.add(val);
        }
        //pop(deletion)
        public static int pop(){

            if(isempty()){
                return -1;
            }

            int deleted = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return deleted;
        }
        //peek (displaying top)
        public static int peek(){

            if(isempty()){
                return -1;
            }

            return list.get(list.size() - 1);
        }

    }
    static class Node{

        int data;
        Node next;
        Node(int val){
            this.data = val;
            this.next = null;
        }
    }
    //class stackB - implementation of stack using linkedlist.
    static class stackB{

        static Node head = null;

        //isempty (checking is empty)
        public static boolean Isempty(){

            if(head == null){
                return true;
            }
            else{
                return false;
            }

        }
        //push (adding element)
        public static void push(int data){

            Node newnode = new Node(data);
            if(Isempty()){
                head = newnode;
                return;
            }
            newnode.next = head;
            head = newnode;
        }
        //pop (deletion)
        public static int pop(){

            if(Isempty()){
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }
        //peek - displaying the top
        public static int peek(){

            if(Isempty()){
                return -1;
            }
            return head.data;
        }
    }
    public static void pushAtBottom(Stack<Integer> s, int data){

        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    public static String reverseString(String str){

        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx < str.length()){

            char curr = s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder newstring = new StringBuilder("");
        while(!s.isEmpty()){

            char curr = s.pop();
            newstring.append(curr);
        }
        //String ans Stringbuilder have different type so we need to convert Stringbuilder to string
        //to do that we use func - str.toString()
        return newstring.toString();
    }
    //function to revers a Stack
    public static void reverseStack(Stack<Integer> s){

        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);  
    }
    public static void printstack(Stack<Integer> s){

        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }

    public static void main(String args[]){

        //implementation of stack using Arraylist

        // stackA s1 = new stackA();
        // s1.push(10);
        // s1.push(3);
        // s1.push(2);
        // s1.push(1);

        // while(!s1.isempty()){

        //     System.out.println(s1.peek());
        //     s1.pop();
        // }

        //implementation of stack using LL

        // System.out.println();
        // stackB s2 = new stackB();
        // s2.push(45);
        // s2.push(39);
        // s2.push(26);
        // s2.push(12);

        // while(!s2.Isempty()){

        //     System.out.println(s2.peek());
        //     s2.pop();
        // }
        // System.out.println();

        //implementation of stack using Java collection Framework
        //imbuilt Stack class

        // Stack<Integer> s3 = new Stack<>();
        // s3.push(101);
        // s3.push(324);
        // s3.push(243);
        // s3.push(120);

        // pushAtBottom(s3, 210);
        // while(!s3.isEmpty()){

        //     System.out.println(s3.peek());
        //     s3.pop();
        // }

        // String str = "if you can read this and understand you are smart then!!";
        // String result = reverseString(str);
        // System.out.println(result);
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        //3,2, 1
        reverseStack(s);
        printstack(s);
        //1,2,3

    }
    
}
