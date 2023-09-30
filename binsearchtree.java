import java.util.*;
public class binsearchtree{

    static class Node{

        int data;
        Node left;
        Node right;

        Node(int val){
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }
    public static Node insertBST(Node root,int val){

        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            root.left = insertBST(root.left, val);
        }
        else if(root.data < val){
            root.right = insertBST(root.right, val);
        }
        return root;
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
    public static boolean binsearch(Node root,int key){

        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        else if(root.data < key){
            return binsearch(root.right, key);
        }
        else{
            return binsearch(root.left, key);
        }
    }
    public static Node inordersuccessor(Node root){

        while(root.left != null){
            root = root.left;
        }
        return root;
    }
    public static Node deletebst(Node root,int key){
     
        //searching process to delete the node
        if(root.data < key){
            root.right = deletebst(root.right, key);
        }
        else if(root.data > key){
            root.left = deletebst(root.left, key);
        }
        //root.data == key Node found
        else{
               
            //case 1 - no child(leaf node)
            if(root.left == null && root.right == null){
                return null;
            }
            //case 2 - single child
            else if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            //case 3 - two child
            Node temp = inordersuccessor(root.right);
            root.data = temp.data;
            root.right = deletebst(root.right,temp.data);
        }
        return root;
    }
    public static void printinrange(Node root,int k1,int k2){
        
        if(root == null){
            return;
        }
        if(root.data >= k1 && root.data <= k2){
            printinrange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printinrange(root.right, k1, k2);
        }
        else if(root.data < k1){
            printinrange(root.left,k1, k2);
        }
        else{
            printinrange(root.right,k1,k2);
        }
        
    }  //inorder but in range between k1 and k2
    public static void printpath(ArrayList<Integer> path){

        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.print("null");
    }
    public static void printroot2leaf(Node root,ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printpath(path);
            System.out.println();
        }
        printroot2leaf(root.left, path);
        printroot2leaf(root.right, path);
        path.remove(path.size() - 1);
    }
    public static boolean isvalidbst(Node root,Node min ,Node max){

        if(root == null){
            return true;
        }
        else if(min != null && root.data <= min.data){
            return false;
        }
        else if(max != null && root.data >= max.data){
            return false;
        }
        return isvalidbst(root.left, min,root) && isvalidbst(root.right,root,max);
    }
    public static Node mirrorbst(Node root){

        if(root == null){
            return null;
        }
        Node leftchild = mirrorbst(root.left);
        Node rightchild = mirrorbst(root.right);

        root.left = rightchild;
        root.right = leftchild;

        return root;
    }
    public static Node CreateBal_tree(int arr[],int start,int end){

        if(start > end){
            return null;
        }
        int mid = (start + end)/2;
        Node root = new Node(arr[mid]);
        root.left = CreateBal_tree(arr,start,mid - 1);
        root.right = CreateBal_tree(arr,mid + 1, end);

        return root;
    }
    public static void getinorder(Node root,ArrayList<Integer> inorder){

        if(root == null){
            return ;
        }
        getinorder(root.left, inorder);
        inorder.add(root.data);
        getinorder(root.right, inorder);
    }
    public static Node createbst(ArrayList<Integer> inorder,int st,int end){
        if(st > end){
            return null;
        }
        int mid = (st + end)/2;
        Node root = new Node(inorder.get(mid));
        root.left = createbst(inorder, st, mid - 1);
        root.right = createbst(inorder,mid + 1, end);

        return root;  
    }
    public static Node balancedBSt(Node root){

        ArrayList<Integer> inorder = new ArrayList<>();
        getinorder(root, inorder);

        root = createbst(inorder, 0,inorder.size()-1);
        return root;
    }
    public static void main (String args[]){           //         5
                                                      //       1     7
        int values[] = {5,1,3,4,2,7};                //     2     3
        int values2[] ={8,5,3,1,4,6,10,11,14};      //             4
        Node root = null;                            

        for(int i=0;i<values2.length;i++){
            root = insertBST(root,values2[i]);
        }

        inorder(root);
        System.out.println();
        //System.out.println(binsearch(root, 2));
        
        root = deletebst(root, 10);
        inorder(root);
        System.out.println();
        printinrange(root, 5, 12);
        System.out.println("\n");

        //printroot2leaf(root,new ArrayList<>());

        //System.out.println(isvalidbst(root,null,null));
       // mirrorbst(root);
        //inorder(root);

        //part -2
        int arr[] = {3,5,6,8,10,11,12};
        int arr2[] = {8,6,5,3,10,11,12};
        ArrayList<Integer> balBST = new ArrayList<>();

        Node root2 = null;                            

        for(int i=0;i<arr2.length;i++){
            root2 = insertBST(root2,arr2[i]);
        }
     // Node root2 = CreateBal_tree(arr, 0, arr.length-1);
        preorder(root2);
        balancedBSt(root2);
        System.out.println();
        preorder(root2);

    }
    
}
