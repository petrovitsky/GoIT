package module9.homework;

public interface MyCollection<E> extends Iterable<E> {
    boolean add(E value);

    boolean remove(int index);

    void clear();

    int size();
}
