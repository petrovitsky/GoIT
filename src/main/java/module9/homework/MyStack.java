package module9.homework;


import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyStack<E> implements Iterable {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private E[] data = (E[]) new Object[DEFAULT_CAPACITY];

    /*
    * push(Object value) добавляет элемент в конец
    remove(int index) удаляет элемент под индексом
    clear() очищает коллекцию
    size() возвращает размер коллекции
    peek() возвращает первый элемент в стеке (LIFO)
    pop() возвращает первый элемент в стеке и удаляет его из коллекции
    * */

    public E pop() {
        E obj;
        int len = size();
        obj = peek();
        remove(len - 1);
        return obj;
    }

    public E peek() {
        if (size == 0)
            throw new EmptyStackException();
        return data[size - 1];
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException();
        }
        remove(data, index);
    }


    private void remove(E[] data, int i) {
        int newSize = size - 1;
        if (newSize > i) {
            System.arraycopy(data, i + 1, data, i, newSize - i);
        }
        size = newSize;
        data[size] = null;
    }

    public E push(Object value) {
        add((E) value, data, size);
        return (E) value;
    }

    private void add(E element, Object[] data, int s) {
        if (s == data.length) {
            data = grow();
        }
        data[s] = element;
        size = s + 1;
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


}
