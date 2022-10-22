package module9.homework;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;


public class MyQueueImpl<E> implements MyQueue<E> {
    private MyLinkedList<E> helper = new MyLinkedList<>();

    @Override
    public boolean add(E value) {
        return helper.add(value);
    }

    @Override
    public boolean remove(int index) {
        return helper.remove(index);
    }

    @Override
    public void clear() {
        helper.clear();
    }

    @Override
    public int size() {
        return helper.size();
    }

    @Override
    public E poll() {
        return helper.poll();
    }

    @Override
    public E peek() {
        return helper.peek();
    }

    @NotNull
    @Override
    public Iterator iterator() {
        return helper.iterator();
    }
}
