package collection.list;

import collection.MyCollection;

public abstract class MyList<E> implements MyCollection<E> {
    protected int size;

    protected MyList() {
        this.size = 0;
    }

    public abstract E get(int index);

    public int size() {
        return size;
    }

    protected void rangeCheck(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index out of range");
    }
}
