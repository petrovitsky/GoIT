package module9.homework;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyLinkedList<E> implements MyList<E>, MyDeque<E> {
    private int size;
    private Node<E> first = new Node<>(null, null, null);
    private Node<E> last = new Node<>(null, null, null);

    public MyLinkedList() {
        last.prev = first;
        first.next = last;
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
        return nodeOf(size -1).item;
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
    public E pop() {
        if (size == 0) {
            throw  new NoSuchElementException();
        } else {
            final E result = nodeOf(size - 1).item;
            remove(size - 1);
            return result;
        }
    }

    @Override
    public void push(E e) {
        addFirst(e);
    }


    public void addFirst(E element) {
        Node<E> current = first;
        current.item = element;
        first = new Node<>(null, null, current);
        current.prev = first;
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
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Incorrect index!!!");
        } else {
            return nodeOf(index).item;
        }
    }

    private Node<E> nodeOf(int index) {
        Node<E> res = first;
        for (int i = 0; i <= index; i++) {
            res = res.next;
        }
        return res;
//
//        if (index < (size >> 1)){
//            Node<E> res = first;
//            for (int i = 0 ; i < index; i ++){
//                res = res.next;
//            }
//            return res;
//        } else {
//            Node<E> res = last;
//            for (int i = 0; i > index ; i--) {
//                res = res.prev;
//            }
//            return res;
//        }
    }

    @NotNull
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public E next() {
                return get(counter++);
            }
        };
    }

    public void printList() {
        if (size == 0) {
            System.out.println("The collection is empty.");
            return;
        }
        for (Object m : this) {
            System.out.println(m);
        }
        System.out.println("------ ---- ----- ---");
    }


}
