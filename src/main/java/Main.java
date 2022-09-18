import collection.MyQueue;
import collection.MyStack;
import collection.list.MyArrayList;
import collection.list.MyLinkedList;
import map.MyHashMap;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> testLinked = new MyLinkedList<>();
        testLinked.add("test1");
        testLinked.add("test2");
        testLinked.add("test3");
        testLinked.add("test4");
        testLinked.add("test5");
        testLinked.add("test6");

        testLinked.remove(0);
        testLinked.remove(4);
        testLinked.remove(2);
        String testValue = testLinked.get(2);
        testLinked.clear();

        MyArrayList<String> testArrayList = new MyArrayList<>();
        testArrayList.add("test1");
        testArrayList.add("test2");
        testArrayList.add("test3");
        testArrayList.add("test4");
        testArrayList.add("test5");
        testArrayList.add("test6");

        testArrayList.remove(0);
        testArrayList.remove(4);
        testArrayList.remove(2);
        testValue = testArrayList.get(2);
        testArrayList.clear();

        MyHashMap<Integer, String> testHashMap = new MyHashMap<>();
        testHashMap.put(1, "test1");
        testHashMap.put(23, "test2");
        testHashMap.put(234, "test3");
        testHashMap.put(23 + 64, "test10");

        testValue = testHashMap.get(23 + 64);

        testHashMap.remove(23);

        testHashMap.clear();

        MyStack<String> testStack = new MyStack<>();

        testStack.push("test1");
        testStack.push("test23");
        testStack.push("test234");
        testStack.peek();
        testValue = testStack.pop();
        int testSize = testStack.size();
        testStack.clear();

        MyQueue<String> testQueue = new MyQueue();
        testQueue.push("test1");
        testQueue.push("test23");
        testQueue.push("test234");
        testValue = testQueue.peek();
        testValue = testQueue.poll();
        testSize = testQueue.size();
        testStack.clear();
    }
}
