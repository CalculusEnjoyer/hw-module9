package collection;

public interface MyCollection<E> {
    void add(E element);

    void remove(int index);

    void clear();

    int size();
}
