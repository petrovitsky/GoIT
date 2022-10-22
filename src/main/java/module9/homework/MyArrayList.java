package module9.homework;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;


public class MyArrayList<E> implements MyList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private E[] data = (E[]) new Object[DEFAULT_CAPACITY];

    public MyArrayList() {
    }

    public MyArrayList(int capacity) {
        data = (E[]) new Object[capacity];
    }


    private Object[] grow() {
        int oldCapacity = data.length;
        if (oldCapacity > 0) {
            data = Arrays.copyOf(data, oldCapacity * 2);
        } else {
            data = (E[]) new Object[DEFAULT_CAPACITY];
        }
        return data;
    }

    private void add(E element, Object[] data, int s) {
        if (s == data.length) {
            data = grow();
        }
        data[s] = element;
        size = s + 1;
    }

    @Override
    public boolean add(E value) {
        add(value, data, size);
        return true;
    }

    @Override
    public boolean remove(int index) {
        remove(data, index);
        return true;
    }

    private void remove(E[] data, int i) {
        int newSize = size - 1;
        if (newSize > i) {
            System.arraycopy(data, i + 1, data, i, newSize - i);
        }
        size = newSize;
        data[size] = null;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        return data[index];
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {

            private int index;

            @Override
            public boolean hasNext() {
                return index < data.length && data[index] != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    return data[index++];
                }
            }
        };
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (E element : data) {
            if (element != null) {
                sj.add(element.toString());
            }
        }
        return sj.toString();
    }
}
