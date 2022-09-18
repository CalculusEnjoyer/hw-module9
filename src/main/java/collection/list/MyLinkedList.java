package collection.list;

import lombok.Getter;
import lombok.Setter;

public class MyLinkedList<E> extends MyList<E> {
    private MyNode<E> first;
    private MyNode<E> last;

    public MyLinkedList() {
        super();
        first = null;
        last = null;
    }

    @Getter
    @Setter
    private static class MyNode<E> {
        private E item;
        private MyNode<E> next;
        private MyNode<E> prev;

        MyNode(MyNode<E> prev, E item, MyNode<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    protected MyNode<E> findNode(int index) {
        rangeCheck(index);
        MyNode<E> result;

        if (index < size / 2) {
            result = first;
            for (int i = 0; i < index; i++) {
                result = result.getNext();
            }
        } else {
            result = last;
            for (int i = size - 1; i > index; i--) {
                result = result.getPrev();
            }
        }
        return result;
    }

    @Override
    public void remove(int index) {
        MyNode<E> targetNode = this.findNode(index);
        if (index == 0) {
            first = targetNode.getNext();
            first.setPrev(null);
        } else if (index == size - 1) {
            last = targetNode.getPrev();
            last.setNext(null);
        } else {
            targetNode.getPrev().setNext(targetNode.getNext());
            targetNode.getNext().setPrev(targetNode.getPrev());
        }
        size--;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }


    @Override
    public E get(int index) {
        return findNode(index).getItem();
    }

    @Override
    public void add(E element) {
        MyNode<E> newNode = new MyNode<>(last, element, null);
        if (last != null) {
            last.setNext(newNode);
        } else {
            first = newNode;
        }
        last = newNode;
        size++;
    }
}
