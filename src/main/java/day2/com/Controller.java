package day2.com;

import day2.model.StudentCompare;
import day2.model.StudentCompareTo;

import java.util.*;

public class Controller {

    public static void main(String[] args) {
        System.out.println("******************** QUEUE **********************");
        // Queues & compare to
        Queue<StudentCompareTo> heap = new PriorityQueue<>();
        heap.offer(new StudentCompareTo(20, "Gabby", "Paul"));
        heap.offer(new StudentCompareTo(19, "Gabby", "Rand"));
        heap.offer(new StudentCompareTo(18, "Randy", "Paul"));

        System.out.println(heap.peek().toString());

        System.out.println("******************** TREE SET **********************");

        // tree set & compare to
        Set<StudentCompareTo> treeSet = new TreeSet<>();
        treeSet.add(new StudentCompareTo(20, "Gabby", "Paul"));
        treeSet.add(new StudentCompareTo(19, "Gabby", "Rand"));
        treeSet.add(new StudentCompareTo(21, "Randy", "Paul"));

        System.out.println(treeSet.stream().findFirst().get().toString());

        // tree set and comparator
        Set<StudentCompare> tree = new TreeSet<>();
        tree.add(new StudentCompare(20, "Gabby", "Paul"));
        tree.add(new StudentCompare(19, "Gabby", "Rand"));
        tree.add(new StudentCompare(21, "Randy", "Paul"));
        tree.add(new StudentCompare(25, "Mayfield", "Weather"));

        System.out.println(tree.stream().findFirst().get().toString());

        System.out.println("******************** STACK **********************");

        //Stacks
        Stack<StudentCompare> studentCompareStack = new Stack<>();
        studentCompareStack.add(new StudentCompare(20, "Gabby", "Paul"));
        studentCompareStack.add(new StudentCompare(19, "Gabby", "Rand"));
        studentCompareStack.add(new StudentCompare(21, "Randy", "Paul"));
        studentCompareStack.add(new StudentCompare(25, "Mayfield", "Weather"));

        System.out.println(studentCompareStack.peek().toString());

        System.out.println("******************** DEQUE **********************");

        //Deque
        Deque<StudentCompare> studentCompareDeque = new ArrayDeque<StudentCompare>();
        studentCompareDeque.add(new StudentCompare(20, "Gabby", "Paul"));
        studentCompareDeque.add(new StudentCompare(19, "Gabby", "Rand"));
        studentCompareDeque.add(new StudentCompare(21, "Randy", "Paul"));
        studentCompareDeque.add(new StudentCompare(25, "Mayfield", "Weather"));

        System.out.println(studentCompareDeque.peek().toString());
        System.out.println(studentCompareDeque.poll().toString());

        System.out.println("******************** HASHMAP **********************");

        // hashmap, compare to and index
        HashMap<Integer, StudentCompare> studentCompareHashMap = new HashMap<>();
        studentCompareHashMap.put(1, new StudentCompare(20, "Gabby", "Paul"));
        studentCompareHashMap.put(2, new StudentCompare(19, "Gabby", "Rand"));
        studentCompareHashMap.put(3, new StudentCompare(21, "Randy", "Paul"));
        studentCompareHashMap.put(4, new StudentCompare(25, "Mayfield", "Weather"));

        System.out.println(studentCompareHashMap.containsKey(7));
        System.out.println(studentCompareHashMap.get(3));

        System.out.println("******************** LINKED LIST **********************");

        //linked list
        LinkedList<StudentCompare> linkedList = new LinkedList<>();
        linkedList.add(new StudentCompare(21, "Mayfield", "Weather"));
        linkedList.add(new StudentCompare(22, "Mayfield", "Mayz"));
        linkedList.add(new StudentCompare(18, "April", "Crocks"));
        linkedList.add(new StudentCompare(17, "August", "Alsina"));

        System.out.println("First: " + linkedList.getFirst().toString());
        System.out.println("Last: " + linkedList.getLast().toString());

        System.out.println("******************** ARRAY LIST **********************");

        // array list
        ArrayList<StudentCompare> arrayList = new ArrayList<>();
        arrayList.add(new StudentCompare(20, "Mayfield", "Weather"));
        arrayList.add(new StudentCompare(25, "Mayfield", "Mayz"));
        arrayList.add(new StudentCompare(17, "April", "Crocks"));
        arrayList.add(new StudentCompare(16, "August", "Alsina"));

        System.out.println("First: " + arrayList.get(0).toString());
        System.out.println("Last: " + arrayList.get(3).toString());

        System.out.println("******************** HASHSET **********************");
        // hash set
        HashSet<String> students = new HashSet<String>();
        students.add("Mayfield");
        students.add("Roger");
        students.add("Gavin");
        students.add("Test5");

        System.out.println(students);
        System.out.println(students.contains("Gabriel"));
        System.out.println(students.contains("gavin"));
        System.out.println(students.contains("Gavin"));


        System.out.println("******************** HASHTABLE **********************");
        Hashtable<Integer, StudentCompare> studentCompareHashtable = new Hashtable<>();
        studentCompareHashtable.put(1, new StudentCompare(20, "Gabby", "Paul"));
        studentCompareHashtable.put(2, new StudentCompare(19, "Gabby", "Rand"));
        studentCompareHashtable.put(3, new StudentCompare(21, "Randy", "Paul"));
        studentCompareHashtable.put(4, new StudentCompare(25, "Mayfield", "Weather"));

        System.out.println(studentCompareHashtable.containsKey(1));
        System.out.println(studentCompareHashtable.get(3));
//        System.out.println(students.contains("Gabriel"));
//        System.out.println(students.contains("gavin"));
//        System.out.println(students.contains("Gavin"));
    }

}
