package s02lambdas;

import java.util.Arrays;
import java.util.Comparator;

public class Main2 {

    public static class Person {

        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }


    public static void main(String[] args) {
        Person[] people = new Person[]{
                new Person("jake", 25),
                new Person("bob", 18),
                new Person("anna", 23)
        };

        System.out.println("---------------------------");
        System.out.println(Arrays.toString(people));

        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getAge() - p2.getAge();
            }
        });

        // Arrays.sort(people, (p1, p2) -> p1.getAge() - p2.getAge());

        System.out.println(Arrays.toString(people));
    }
}
