package module9.homework;


import java.util.Iterator;


public class MyQueueImpl<E> implements MyQueue<E> {

    private int size;
    private Node<E> first = new Node<>(null, null, null);
    private Node<E> last = new Node<>(null, null, null);

    public MyQueueImpl() {
        last.prev = first;
        first.next = last;
    }

    private MyLinkedList<E> helper = new MyLinkedList<>();

    @Override
    public boolean add(E value) {
        addLast(value);
        return true;
    }

    public void addLast(E value) {
        Node<E> current = last;
        current.item = value;
        last = new Node<>(current, null, null);
        current.next = last;
        size++;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Incorrect index!!!");
        }
        Node<E> toRemove = nodeOf(index);

        if (index == 0) {
            first.next = toRemove.next;
            toRemove.next.prev = first;
            toRemove.next = toRemove.prev = null;
            size--;
            return true;
        }
        if (index == size - 1) {
            toRemove.prev.next = last;
            last.prev = toRemove.prev;
            toRemove.next = toRemove.prev = null;
            size--;
            return true;
        }

        toRemove.prev.next = toRemove.next;
        toRemove.next.prev = toRemove.prev;
        toRemove.next = toRemove.prev = null;
        size--;

        return true;
    }

    @Override
    public void clear() {
        first.next = last;
        last.prev = first;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E poll() {
        if (size == 0) {
            return null;
        } else {
            final E result = nodeOf(0).item;
            remove(0);
            return result;
        }
    }

    @Override
    public E peek() {
        return nodeOf(0).item;
    }

    private Node<E> nodeOf(int index) {
        Node<E> res = first;
        for (int i = 0; i <= index; i++) {
            res = res.next;
        }
        return res;

    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int counter;
            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public Object next() {
                return get(counter++);
            }
        };
    }

    private E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Incorrect index!!!");
        } else {
            return nodeOf(index).item;
        }
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

    }
}
