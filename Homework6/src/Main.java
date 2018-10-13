import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayListTest();
        LinkedListTest();
        StackTest();
        QueueTest();
        HashMapTest();
    }

    private static void ArrayListTest(){
        MyArrayList arr = new MyArrayList();
        arr.add("a");
        arr.add(2);
        arr.add("b");
        arr.add("c");
        arr.add(5);

        System.out.println(arr);
        arr.remove(1);
        System.out.println("Remove element at index 1.");
        System.out.println(arr);

        System.out.println("element at index 2: " + arr.get(2));
        System.out.println("Size = " + arr.size() + "\n");
    }

    private static void LinkedListTest(){
        MyLinkedList arr = new MyLinkedList();
        arr.add("a");
        arr.add(2);
        arr.add("b");
        arr.add("c");
        arr.add(5);

        System.out.println(arr);
        arr.remove(1);
        System.out.println("Remove element at index 1.");
        System.out.println(arr);

        System.out.println("element at index 2: " + arr.get(2));
        System.out.println("Size = " + arr.size() + "\n");
    }

    private static void StackTest(){
        MyStack arr = new MyStack();
        arr.push("a");
        arr.push(2);
        arr.push("b");
        arr.push("c");
        arr.push(5);

        System.out.println(arr);
        arr.remove(1);
        System.out.println("Remove element at index 1.");
        System.out.println(arr);

        System.out.println("Peek: " + arr.peek());
        System.out.println("Pop: " + arr.pop());
        System.out.println(arr);
        System.out.println("Size = " + arr.size() + "\n");
    }

    private static void QueueTest(){
        MyQueue arr = new MyQueue();
        arr.add("a");
        arr.add(2);
        arr.add("b");
        arr.add("c");
        arr.add(5);

        System.out.println(arr);
        arr.remove(1);
        System.out.println("Remove element at index 1.");
        System.out.println(arr);

        System.out.println("Peek: " + arr.peek());
        System.out.println("Pop: " + arr.poll());
        System.out.println(arr);
        System.out.println("Size = " + arr.size() + "\n");
    }

    private static void HashMapTest(){
        MyHashMap arr = new MyHashMap();
        arr.put(1 , "a");
        arr.put(2, 2);
        arr.put(10, "b");
        arr.put(7, "c");
        arr.put(5, 5);

        System.out.println(arr);
        arr.remove(10);
        System.out.println("Remove element with key 10.");
        System.out.println(arr);

        System.out.println("Element at key 2: " + arr.get(2));
        System.out.println("Size = " + arr.size() + "\n");
    }

}
