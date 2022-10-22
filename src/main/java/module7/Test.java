package module7;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test{
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("First");
        list.add("Second");
        list.add("Third");

        List<String> newList = new LinkedList<>();
        newList.addAll(list);

        System.out.println("newList = " + newList);
        System.out.println("list = " + list);
    }
}

interface A {
    void printerA();
    default void printer(String text){
        System.out.println("Input data is: " + text);

    }
}

interface AA extends A {

}

class ClassA implements AA {


    public void someMeth (){
        System.out.println("someMeth of class A");
    }

    @Override
    public void printerA() {

    }
}

class B implements  Iterable<B>{
    private A item;

    public A getItem() {
        return item;
    }

    B(A item) {
        this.item = item;
    }

    @Override
    public Iterator<B> iterator() {
        return new Iterator<B>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public B next() {
                return null;
            }
        };
    }
}

