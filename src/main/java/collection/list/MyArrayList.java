package collection.list;

import java.util.Arrays;

public class MyArrayList<E> extends MyList<E> {
    private Object[] items;

    private static final double GROWING_SPEED = 1.5;

    public MyArrayList() {
        this(0);
    }

    public MyArrayList(int initialCapacity) {
        this.items = new Object[initialCapacity];
    }

    protected void grow() {
        if (items.length == 0) {
            items = Arrays.copyOf(items, 1);
        } else if (Math.ceil(items.length * GROWING_SPEED) > Integer.MAX_VALUE) {
            items = Arrays.copyOf(items, Integer.MAX_VALUE);
        } else {
            items = Arrays.copyOf(items, (int) Math.ceil(items.length * GROWING_SPEED));
        }
    }

    @Override
    public void add(E element) {
        if (size == Integer.MAX_VALUE) {
            throw new OutOfMemoryError("List is full");
        } else if (items.length < size + 1) {
            grow();
        }
        items[size] = element;
        size++;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elementData(index);
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }
        size = 0;
    }

    @Override
    public void remove(int index) {
        rangeCheck(index);
        int numMoved = size - index - 1;
        System.arraycopy(items, index + 1, items, index, numMoved);
        items[--size] = null;
    }

    @SuppressWarnings("unchecked")
    private E elementData(int index) {
        return (E) items[index];
    }
}
