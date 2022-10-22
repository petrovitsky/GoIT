package module9.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestModule {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal());
        animals.add(new Animal());

        List<Pet> pets = new ArrayList<>();
        pets.add(new Pet());
        pets.add(new Pet());

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());
        cats.add(new Cat());

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());

        iterateAnimals(animals);
        iterateAnimals(pets);
        iterateAnimals(cats);
        iterateAnimals(dogs);

    }
    public static void iterateAnimals(Collection<? extends Animal> animals) {

        for(Animal animal: animals) {

            System.out.println("Еще один шаг в цикле пройден!");
        }
    }
}

class Animal {

    public void feed() {

        System.out.println("Animal.feed()");
    }
}

class Pet extends Animal {

    public void call() {

        System.out.println("Pet.call()");
    }
}

class Cat extends Pet {

    public void meow() {

        System.out.println("Cat.meow()");
    }
}

class Dog extends Pet {

    public void Dog() {

        System.out.println("Dog.woof()");
    }
}

class TypeArrayPrinter {
    public <E> void printer(E[] data) {
        int counter = 1;
        for (E element : data) {
            System.out.println("element " + counter++ + " = " + element);
        }
    }
}