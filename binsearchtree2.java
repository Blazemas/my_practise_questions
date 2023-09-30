import java.util.*;

import org.w3c.dom.Node;
public class binsearchtree2{


    static class Node{

        int data;
        Node left;
        Node right;

        Node(int val){
            this.data = val;
            this.left = this.right = null;
        }
    }
    static class info{

        boolean isbst;
        int size;
        int min;
        int max;

        info(boolean isbst,int size,int min,int max){
            this.isbst = isbst;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    public static int Maxbstsize = 0;

    public static info largestbst(Node root){

        if(root == null){
            return new info(true,0,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }

        info leftinfo = largestbst(root.left);
        info rightinfo = largestbst(root.right);

        int size = leftinfo.size + rightinfo.size + 1;
        int min = Math.min(root.data,Math.min(leftinfo.min,rightinfo.min));
        int max = Math.max(root.data,Math.max(leftinfo.max,rightinfo.max));

        if(root.data <= leftinfo.max && root.data >= rightinfo.min){
            return new info(false,size,min,max);
        }
        if(leftinfo.isbst && rightinfo.isbst){
            Maxbstsize = Math.max(Maxbstsize,size);
            return new info(true,size,min,max);
        }
        return new info(false,size,min,max);
    }
    public static void inorder(Node root){

        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void preorder(Node root){

        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void getinorder(Node root,ArrayList<Integer> arr){

        if(root == null){
            return ;
        }
        getinorder(root.left,arr);
        arr.add(root.data);
        getinorder(root.right,arr);
    }
    public static Node mergeBst(Node root1,Node root2){

        //step-1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getinorder(root1, arr1);
        //step-2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getinorder(root2, arr2);

        //merge
        int i=0;
        int j=0;

        ArrayList<Integer> finalarr = new ArrayList<>();
        //sorting and merging
        while(i<arr1.size() && j<arr2.size()){
            
            if(arr1.get(i) <= arr2.get(j)){
                finalarr.add(arr1.get(i));
                i++;
            }
            else{
                finalarr.add(arr2.get(j));
                j++;
            }
        }
        while(i<arr1.size()){
            finalarr.add(arr1.get(i));
            i++;
        }
        while(j<arr2.size()){
            finalarr.add(arr2.get(j));
            j++;
        }
        //sorted Al -> create merged BST
        return createBST(finalarr,0,finalarr.size() - 1);
    }
    public static Node createBST(ArrayList<Integer> arr,int st,int end){

        if(st > end){
            return null;
        }
        int mid = (st + end)/2;
        Node root = new Node(arr.get(mid));
        root.left = createBST(arr,st,mid - 1);
        root.right = createBST(arr,mid + 1, end);
        return root;

    }
    public static void main(String args[]){


        // Node root = new Node(50);
        // root.left = new Node(30);
        // root.left.left = new Node(5);
        // root.left.right = new Node(20);

        // root.right = new Node(60);
        // root.right.left = new Node(45);
        // root.right.right = new Node(70);
        // root.right.right.left = new Node(65);
        // root.right.right.right = new Node(80);

        // info nodeinfo = largestbst(root);
        // System.out.println("largest bst: "+Maxbstsize);
        //inorder(root);

        //Merging two BSTS

        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergeBst(root1, root2);
        preorder(root);
    }
    
}
