package module9.homework;

public class Test {
    public static void main(String[] args) {
        MyList<Integer> array = new MyArrayList<>();
        MyList<Integer> linked = new MyLinkedList<>();
        MyQueue<Integer> queue = new MyQueueImpl<>();




        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        for (Integer i : stack) {
            System.out.println(i);}

        System.out.println("stack.peek() = " + stack.peek());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.peek() = " + stack.peek());


    }
}