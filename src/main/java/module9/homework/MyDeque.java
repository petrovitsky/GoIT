package module9.homework;


import java.util.NoSuchElementException;

public interface MyDeque <E> extends MyQueue<E> {
    void addFirst(E e);

    void addLast(E e);

    // *** Stack methods ***

    /**
     * Pops an element from the stack represented by this deque.  In other
     * words, removes and returns the first element of this deque.
     *@return the element at the front of this deque (which is the top
     *         of the stack represented by this deque)
     * @throws NoSuchElementException if this deque is empty
     */
    E pop();

/**
 * Pushes an element onto the stack represented by this deque (in other
 * words, at the head of this deque) if it is possible to do so
 * immediately without violating capacity restrictions, throwing an
 * {@code IllegalStateException} if no space is currently available.
 *
 * <p>This method is equivalent to {@link #addFirst}.
 *
 * @param e the element to push
 * */
    void push(E e);
}
