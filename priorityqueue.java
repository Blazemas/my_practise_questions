import java.util.*;
public class priorityqueue{

    static class Student implements Comparable<Student>{  //gives the object of student can be compared now.

        String name;
        int rank;

        public Student(String name,int rank){
            this.name = name;
            this.rank = rank;
        }
    } 
    @Override   
    public int compareTO(Student s2){  //logic to compare the objects
        return this.rank - s2.rank;
    }

    public static void main(String args[]){

        //comparator.reverseorder for reversing the logic (descending priority)
        PriorityQueue<Student> q = new PriorityQueue<>();

        q.add(new Student("A", 7));
        q.add(new Student("B", 5));
        q.add(new Student("C", 1));
        q.add(new Student("D", 11));

        while(!q.isEmpty()){
            System.out.println(q.peek().name +"->" +q.peek().rank);
            q.remove();
        }


    }
    
}
