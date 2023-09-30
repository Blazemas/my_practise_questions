import java.util.*;

public class hashing{

    public static void main(String args[]){
         //creating
        HashMap<String,Integer> map = new HashMap<>();

  //****************************Some HashMap operations********************************************** */      
         //insert - O(1)
   /*   map.put("india",100);
        map.put("china",130);
        map.put("USA",180);

        System.out.println(map);  //stored in random order

        //get - O(1)
        System.out.println(map.get("india"));  //return value of that key
        System.out.println(map.get("nepal"));  //for invalid key returns null 

        //Containskey - O(1)  cheack whether the key exist in map or not
        System.out.println(map.containsKey("india"));  //return true
        System.out.println(map.containsKey("napal"));   //return false

        //remove - O(1) removes the value and key but return the value(int)

        System.out.println(map.remove("china"));
        System.out.println(map.remove("nepal"));  //for non existing key return null
        System.out.println(map);

        //size - return the size of Hashmap
        System.out.println(map.size());

        //isempty - check whether the hashmap is empty or not(true or false)
        System.out.println(map.isEmpty());

        //clear - removes all data from hashmap
        map.clear();
        System.out.println(map.isEmpty());*/
//************************************************************************************************************ */
        map.put("india",100);
        map.put("china",130);
        map.put("USA",180);
        map.put("France",280);
        map.put("UK",210);
       
        //keySet - to iterate
        Set<String> keys = map.keySet();  //stores the key values only from hashmap(in random order)
        System.out.println(keys);
        // to iterate
        for(String k : keys){
            System.out.println("key: "+k + ", value: "+map.get(k));
        }
        
    }
    
}
