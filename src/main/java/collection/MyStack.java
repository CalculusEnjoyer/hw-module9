package collection;

import collection.list.MyArrayList;
import collection.list.MyList;

public class MyStack<E> implements MyCollection<E> {
    // MyStack and MyQueue work and would store objects nearly the same
    // as MyList except for pop(), push(), peek() methods
    // (and it is very easy to implement them using add() and remove() from MyList).
    // In order to avoid code duplication, I decided to store elements in MyList field.
    // Additionally, it would be effortless to change it from MyArrayList
    // to MyLinkedList if needed.
    MyList<E> items = new MyArrayList<>();

    @Override
    public int size() {
        return items.size();
    }

    public void push(E value) {
        items.add(value);
    }

    @Override
    public void remove(int index) {
        items.remove(index);
    }

    @Override
    public void clear() {
        items.clear();
    }

    public E peek() {
        return items.get(items.size() - 1);
    }

    public E pop() {
        E result = items.get(items.size() - 1);
        items.remove(items.size() - 1);
        return result;
    }

    @Override
    public void add(E element) {
        push(element);
    }
}
