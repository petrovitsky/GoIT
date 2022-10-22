package module9.homework;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class MyStack <E> implements MyDeque<E> {
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
    public void addFirst(E e) {
        helper.addFirst(e);
    }

    @Override
    public void addLast(E e) {
        helper.addLast(e);
    }

    @Override
    public E pop() {
        return helper.pop();
    }

    @Override
    public void push(E e) {
        addLast(e);
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
    public Iterator<E> iterator() {
        return helper.iterator();
    }
}
