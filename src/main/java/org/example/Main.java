package org.example;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Олександр", "Хлівненко", 123);
        Student student2 = new Student("Марія", "Іловайська", 124);

        Course mathCourse = new Course("Математика");
        Course physicsCourse = new Course("Фізика");

        student1.addCourse(mathCourse);
        student1.addCourse(physicsCourse);

        student2.addCourse(mathCourse);

        mathCourse.printStudents();
        physicsCourse.printStudents();

        student1.printInfo();
        student2.printInfo();
    }
    public static class Student {
        private String firstName;
        private String lastName;
        private int groupNumber;
        private ArrayList<Course> courses;

        public Student(String firstName, String lastName, int groupNumber) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.groupNumber = groupNumber;
            this.courses = new ArrayList<>();
        }

        public void addCourse(Course course) {
            courses.add(course);
            course.addStudent(this);
        }

        public void removeCourse(Course course) {
            courses.remove(course);
            course.removeStudent(this);
        }

        public void printInfo() {
            System.out.println("Ім'я: " + firstName);
            System.out.println("Прізвище: " + lastName);
            System.out.println("Номер групи: " + groupNumber);
            System.out.println("Курси, на які записаний студент: ");
            for (Course course : courses) {
                System.out.println(course.getName());
            }
        }
    }

    public static class Course {
        private String name;
        private ArrayList<Student> students;

        public Course(String name) {
            this.name = name;
            this.students = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void addStudent(Student student) {
            students.add(student);
        }

        public void removeStudent(Student student) {
            students.remove(student);
        }

        public void printStudents() {
            System.out.println("Список студентів на курсі " + getName() + ":");
            for (Student student : students) {
                System.out.println(student.firstName + " " + student.lastName);
            }
        }
    }
}
