package module6;

public class Main {
    public static void main(String[] args) {
         B b = new B();

    }
}

class A {
    private String name;
    private String surName;
}

class B {
    {
        System.out.println("non static init block");
    }
    public B (){
        System.out.println("Constructor");
    }
}
