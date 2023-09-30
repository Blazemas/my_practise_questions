// public class binarytree{
    
//     static class Node{

//         int data;
//         Node left;
//         Node right;

//         Node(int val){

//             this.data = val;
//             this.left = null;
//             this.right = null;
//         }
//     }
//     static class Bintree{

//         static int idx = -1;
//         public static Node buildtree(int nodes[]){
//             idx++;
//             if(nodes[idx] == -1){
//                 return null;
//             }
//             Node newnode = new Node(nodes[idx]);
//             newnode.left = buildtree(nodes);
//             newnode.right = buildtree(nodes);

//             return newnode;
//         }
//     }
//     public static void main(String args[]){

//         int nodes[] = {1,4,2,6,-3,5,53,12};
//         Bintree tree = new Bintree();
//         Node root = tree.buildtree(nodes);       
//         System.out.println(root.data);     
//     }
// }
import java.util.*;
public class binarytree{
    
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }
    //building tree from a array in preorder
    static class Bintree {
        public static Node buildTree(int nodes[], int index) {
            if(index >= nodes.length || nodes[index] == -1){
                return null;
            }
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes, 2 * index + 1); // Left child
            newNode.right = buildTree(nodes, 2 * index + 2); // Right child

            return newNode;
        }
    }
    public static void preorder(Node root){

        if(root == null){
            return ;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void inorder(Node root){

        if(root == null){
            return ;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void postorder(Node root){

        if(root == null){
            return ;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    public static void levelorder(Node root){

        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){

            Node currnode = q.remove();
            if(currnode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(currnode.data+" ");
                if(currnode.left != null){
                    q.add(currnode.left);
                }
                if(currnode.right != null){
                    q.add(currnode.right);
                }
            }
            
        }
    }
    public static int height_of_tree(Node root){  //O(n)

        if(root == null){
            return 0;
        }
        int left_H = height_of_tree(root.left);
        int right_H = height_of_tree(root.right);

        int height = Math.max(left_H,right_H) + 1;
      
        return height;
    }
    public static int countnode(Node root){  //O(n)

        if(root == null){
            return 0;
        }
        int left_count = countnode(root.left);
        int right_count = countnode(root.right);

        int nodecount = left_count + right_count + 1;
      
        return nodecount;
    }
    public static int sumofnode(Node root){  //O(n)

        if(root == null){
            return 0;
        }
        int left_sum = sumofnode(root.left);
        int right_sum = sumofnode(root.right);

        int totalsum = left_sum + right_sum + root.data;
      
        return totalsum;
    }
    public static int diameteroftree(Node root){   //O(n2)

        if(root == null){  //base case
            return 0;
        }
        int L_diameter = diameteroftree(root.left);
        int R_diameter = diameteroftree(root.right);

        int L_height = height_of_tree(root.left);
        int R_height = height_of_tree(root.right);

        int self_diameter = L_height + R_height;

        return Math.max(self_diameter,Math.max(L_diameter,R_diameter));
        
    }
    static class info{

        int diameter;
        int ht;

        public info(int val , int hgt){
            this.diameter = val;
            this.ht = hgt;
        }
    }
    public static info diameteroftree2(Node root){

        if(root == null){
            return new info(0,0);
        }
        info R_info = diameteroftree2(root.right);
        info L_info = diameteroftree2(root.left); 

        int diameter = Math.max(Math.max(R_info.diameter,L_info.diameter),(L_info.ht + R_info.ht + 1));

        int height = Math.max(R_info.ht,L_info.ht) + 1;

        return new info(diameter, height);
    }
    static class info2{

        Node node;
        int hor_dist;

        public info2(Node node,int hor_dist){
            this.node=node;
            this.hor_dist=hor_dist;
        }
    }
    public static void topview(Node root){      //finding the nodes which will be visible if saw from top.

        //level order
        Queue<info2> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>(); //HashMap data structure is used to store key(unique),value

        int min = 0;     //minimum horizontal distance
        int max = 0;     //maximum horizontal distance
        info2 newnode = new info2(root,0);
        q.add(newnode); 
        q.add(null);

        while(!q.isEmpty()){

            info2 curr = q.remove();
            if(curr == null){

                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }                   
            }
            else{
                if(!map.containsKey(curr.hor_dist)){  //first time my horizontal distance is occuring

                    map.put(curr.hor_dist,curr.node);
                }
                if(curr.node.left != null){
                    q.add(new info2(curr.node.left,curr.hor_dist - 1));
                    min = Math.min(min,curr.hor_dist - 1);
                }
                if(curr.node.right != null){
                    q.add(new info2(curr.node.right,curr.hor_dist + 1));
                    max = Math.max(max,curr.hor_dist + 1);
                }
            }
         
        }
        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();    
    }
    public static void kthlevel(Node root,int level,int k){

        if(root == null){
            return;
        }
        if(level == k){
            System.out.print(root.data+" ");
            return;
        }
        kthlevel(root.left, level+1, k);
        kthlevel(root.right, level+1, k);
    }

    public static boolean getpath(Node root,int n,ArrayList<Node> path){

        if(root == null){
            return false;
        }
        path.add(root);
        if(root.data == n){
            return true;
        }
        boolean foundleft = getpath(root.left,n,path);
        boolean foundright = getpath(root.right,n,path);

        if(foundleft || foundright){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    
    public static Node lca(Node root,int n1,int n2){ // O(n) with auxilary space for findling the least common ancestor

        ArrayList<Node> path1 = new ArrayList<>(); //path from root to n1 node 
        ArrayList<Node> path2 = new ArrayList<>();  //path from root to n2 node

        getpath(root,n1,path1);
        getpath(root,n2,path2);
     
        //last common ancestor
        int i=0;
        for(;i<path1.size() && i<path2.size();i++){

            if(path1.get(i) != path2.get(i)){   //the last common elements will be the common ancestor
                break;
            }
        }
        Node lca = path1.get(i-1);   //LCA
        return lca;
    }
    public static Node lca2(Node root,int n1,int n2){  //O(n) with constant space 

        if(root == null){
            return null;
        }
        if(root.data == n1 || root.data == n2){

            return root;
        }

        Node leftlca = lca2(root.left,n1,n2);
        Node rightlca = lca2(root.right,n1,n2);

        //if leftlca = null and rightlca = valid(val)
        if(leftlca == null){
            return rightlca;
        }
        if(rightlca == null){
            return leftlca;
        }
        return root;
    }

    public static int lcadist(Node root, int n){   //to find dist from lca to node n

        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int leftdist = lcadist(root.left, n);
        int rightdist = lcadist(root.right, n);

        if(leftdist == -1 && rightdist == -1){
            return -1;
        }
        else if(leftdist == -1){
            return rightdist + 1;
        }
        else{
            return leftdist + 1;
        }
    }
    public static int min_dist(Node root,int n1,int n2){  //to Find minimum dist between two nodes

        Node lcanode = lca2(root, n1, n2);  
        int L_dist = lcadist(root,n1); // dist from lca to n1
        int R_dist = lcadist(root,n2);  // dist from lca to n2
        
        return L_dist + R_dist;   //total min dist between nodes
    }
    public static int Kth_ancestor(Node root,int n ,int k){   //to find kth ancestor

        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int left = Kth_ancestor(root.left,n,k);
        int right = Kth_ancestor(root.right,n,k);

        if(left == -1 && right == -1){
            return -1;
        }
        int max = Math.max(left,right);
        if(max + 1 == k ){
            System.out.println(root.data);
        }
        return max + 1;
    }
    public static int transform(Node root){  //tranforming normal tree into sum tree

        if(root == null){
            return 0;
        }
        int leftchild = transform(root.left);
        int rightchild = transform(root.right);

        int data = root.data;
        int newleft = root.left == null ? 0 :root.left.data;
        int newright = root.right == null ? 0 :root.right.data;
        root.data = newleft + leftchild + newright + rightchild;
        return data;
    }

    public static void main(String args[]) {             //Tree structure
        int nodes[] = {1, 4, 2, 6, 3, 5, 53};                 //1
        Bintree tree = new Bintree();                    //4         2      
        Node root = tree.buildTree(nodes, 0);       //  6    3     5   53
        System.out.println(root.data);
        //System.out.println(); 
        //postorder(root);
       // System.out.println(); 
        //levelorder(root);   
        System.out.println();
        //System.out.println(height_of_tree(root));
        //System.out.println(countnode(root));
        //System.out.println(sumofnode(root));
       // System.out.println(diameteroftree(root));
       // System.out.println(diameteroftree2(root).diameter);
       // topview(root);
        //kthlevel(root, 1, 2);
        System.out.println(lca(root,53, 5).data);      //for findling the least common ancestor]
        System.out.println();
        //System.out.println(lca2(root, 53, 5).data);

       // System.out.println(min_dist(root, 3, 5));  //to find min dist between two nodes(no.edges)

        //Kth_ancestor(root,5,1);  //to find kth ancestor

        transform(root);
        preorder(root);
    }
}

