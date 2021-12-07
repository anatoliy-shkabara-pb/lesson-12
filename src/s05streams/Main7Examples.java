package s05streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main7Examples {


    public static void main(String[] args1) {
        List<Student> students = Arrays.asList(
                new Student("Alex", Speciality.Physics, 1),
                new Student("Rika", Speciality.Biology, 4),
                new Student("Julia", Speciality.Biology, 2),
                new Student("Steve", Speciality.History, 4),
                new Student("Mike", Speciality.Finance, 1),
                new Student("Hinata", Speciality.Biology, 2),
                new Student("Richard", Speciality.History, 1),
                new Student("Kate", Speciality.Psychology, 2),
                new Student("Sergey", Speciality.ComputerScience, 4),
                new Student("Maximilian", Speciality.ComputerScience, 3),
                new Student("Tim", Speciality.ComputerScience, 5),
                new Student("Ann", Speciality.Psychology, 1)
        );

        // Нужно сгруппировать всех студентов по курсу.
        students.stream()
                .collect(Collectors.groupingBy(Student::getYear))
                .entrySet()
                .forEach(System.out::println);

        System.out.println("----------------------------------------");

        // Вывести в алфавитном порядке список специальностей, на которых учатся перечисленные в списке студенты.
        students.stream()
                .map(Student::getSpeciality)
                .distinct()
                .sorted(Comparator.comparing(Enum::name))
                .forEach(System.out::println);

        System.out.println("----------------------------------------");

        // Вывести количество учащихся на каждой из специальностей.
        students.stream()
                .collect(Collectors.groupingBy(
                        Student::getSpeciality, Collectors.counting()))
                .forEach((s, count) -> System.out.println(s + ": " + count));

        System.out.println("----------------------------------------");

        // Сгруппировать студентов по специальностям, сохраняя алфавитный порядок специальности, а затем сгруппировать по курсу.
        Map<Speciality, Map<Integer, List<Student>>> result = students.stream()
                .sorted(Comparator
                        .comparing(Student::getSpeciality, Comparator.comparing(Enum::name))
                        .thenComparing(Student::getYear)
                )
                .collect(Collectors.groupingBy(
                        Student::getSpeciality,
                        LinkedHashMap::new,
                        Collectors.groupingBy(Student::getYear)));

        result.forEach((s, map) -> {
            System.out.println("-= " + s + " =-");
            map.forEach((year, list) -> System.out.format("%d: %s%n", year, list.stream()
                    .map(Student::getName)
                    .sorted()
                    .collect(Collectors.joining(", ")))
            );
            System.out.println();
        });

        // Проверить, есть ли третьекурсники среди учащихся всех специальностей кроме физики и CS.
        boolean res = students.stream()
                .filter(s -> !EnumSet.of(Speciality.ComputerScience, Speciality.Physics)
                        .contains(s.getSpeciality()))
                .anyMatch(s -> s.getYear() == 3);
        System.out.println("res: " + res);
    }

    enum Speciality {
        Biology, ComputerScience, Economics, Finance,
        History, Philosophy, Physics, Psychology
    }

    static class Student {
        private String name;
        private Speciality speciality;
        public int year;

        public Student(String name, Speciality speciality, int year) {
            this.name = name;
            this.speciality = speciality;
            this.year = year;
        }

        public String getName() {
            return name;
        }

        public Speciality getSpeciality() {
            return speciality;
        }

        public int getYear() {
            return year;
        }


        public void setName(String name) {
            this.name = name;
        }

        public void setSpeciality(Speciality speciality) {
            this.speciality = speciality;
        }

        public void setYear(int year) {
            this.year = year;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return year == student.year && Objects.equals(name, student.name) && speciality == student.speciality;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, speciality, year);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", speciality=" + speciality +
                    ", year=" + year +
                    '}';
        }
    }
}
