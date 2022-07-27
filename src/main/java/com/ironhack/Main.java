package com.ironhack;

import com.ironhack.serialization.Serialization;
import com.ironhack.serialization.Student;
import com.ironhack.serialization.Teacher;

import java.util.Map;

import static com.ironhack.serialization.Table.*;

public class Main {

    public static int age = 20;

    public static void main(String[] args) {

        Student stu0 = createStudent();
        Student stu1 = createStudent();
        Student stu2 = createStudent();
        Student stu3 = createStudent();

        Teacher tea0 = createTeacher();
        Teacher tea1 = createTeacher();
        Teacher tea2 = createTeacher();
        Teacher tea3 = createTeacher();

        // Give any filename
        Serialization.put(stu0, USER);
        Serialization.put(stu1, USER);
        Serialization.put(stu2, USER);
        Serialization.put(stu3, USER);

        Serialization.put(tea0, USER);
        Serialization.put(tea1, USER);
        Serialization.put(tea2, USER);
        Serialization.put(tea3, USER);

        // Provide the file name of your serialized object
        Student newStu = (Student) Serialization.getById(stu0.getId(), USER);
        newStu.setName("Ronaldinho");
        Serialization.replace(newStu, USER);
        Serialization.delete(stu2.getId(), USER);
        Student student1 = new Student();
        student1.setName("New Name II");
        student1.setAge(age);
        age++;
        Serialization.put(student1, USER);

        Map newStudents = Serialization.getAll(USER);
        for (Object o : newStudents.values()) {
            if(o instanceof Student) {
                var student = (Student) o;
                System.out.println("ID: " + student.getId() + " -- Name: " + student.getName() + " -- Age: " + student.getAge());
            }
        }

        Teacher newTea = (Teacher) Serialization.getById(tea0.getId(), USER);
        newTea.setName("Messi");
        Serialization.replace(newTea, USER);
        Serialization.delete(tea2.getId(), USER);
        Teacher teacher1 = new Teacher();
        teacher1.setName("New Name III");
        teacher1.setAge(age);
        age++;
        Serialization.put(teacher1, USER);

        Map newTeachers = Serialization.getAll(USER);
        for (Object o : newTeachers.values()) {
            if (o instanceof Teacher) {
                var teacher = (Teacher) o;
                System.out.println("ID: " + teacher.getId() + " -- Name: " + teacher.getName() + " -- Age: " + teacher.getAge());
            }
        }
    }

    /**
     * Create a sample Student object.
     *
     * @return a Student object.
     */
    public static Student createStudent() {
        // Create a Student object
        Student stu = new Student();
        stu.setName("Alice");
        stu.setAge(age);
        age++;

        return stu;
    }

    /**
     * Create a sample Teacher object.
     *
     * @return a Teacher object.
     */
    public static Teacher createTeacher() {
        // Create a Teacher object
        Teacher tea = new Teacher();
        tea.setName("New Name");
        tea.setAge(age);
        age++;

        return tea;
    }
}