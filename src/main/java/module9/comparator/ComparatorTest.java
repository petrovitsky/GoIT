package module9.comparator;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Eugene", "P", 38));
        list.add(new Employee("Aleks", "K", 34));
        list.add(new Employee("Olga", "A", 56));
        list.sort(new ComparatorEmployee());
        System.out.println(list);

    }
}


class Employee implements Comparable <Employee> {
    private String firstName;
    private String lastName;
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "{" + firstName +
                ", " + lastName + ", " + age +
                '}';
    }

    public Employee(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public int compareTo(@NotNull Employee o) {


        return this.lastName.compareTo(o.getLastName());
    }
}

 class GodComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o2.getAge() - o1.getAge();
    }
}

class ComparatorEmployee extends GodComparator {


}