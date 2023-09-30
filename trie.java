public class trie{

    static class Node{

        Node children[] = new Node[26];
        boolean endofword = false;
        int freq;
        Node(){

            for(int i=0;i<26;i++){
                children[i] = null;
            }
            freq = 1;
        }
    }
    public static Node root = new Node();  //root Node in trie is always empty

    public static void insert(String word){ // O(L) depends on length of word

        Node curr = root;
        for(int level=0;level<word.length();level++){

            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null){

                curr.children[idx] = new Node();
            }
            curr = curr.children[idx]; //updating curr
        }

        curr.endofword = true;
    }
    public static boolean search(String word){ // O(L) depends on length of word

        Node curr = root;
        for(int level=0;level<word.length();level++){

            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.endofword == true;
    }

    public static void main(String args[]){ //O(L)

        String ch = "hello my name is chinmay";
        System.out.println(ch.charAt(6));

        String words[] = {"the","a","thor","ironma","spiderman"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        System.out.println(search("man"));

        


    }
    
}
