package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Course course = new Course("English");
        course = addStudent(course);
        displayStudent(course);
        dropStudent(course);
        displayStudent(course);
        course.clear();
        displayStudent(course);
    }

    public static Course addStudent(Course course){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the amount of students: ");
        int amount = scanner.nextInt();
        if(amount > 0){
            for(int i = 0; i <= amount; i++){
                System.out.print("Input the name of the "+i+" student: ");
                String name = scanner.nextLine();
                if(!name.equals("")) {
                    course.addStudent(name);
                }
            }
        }else{
            System.out.println("Invalid amount");
            addStudent(course);
        }
        return course;
    }

    public static void displayStudent(Course course){
        System.out.println("Course name: "+course.getName());
        for(int i = 0; i < course.getStudentsCount(); i++){
            System.out.println("Student "+i+" is: "+course.getStudents()[i]);
        }
    }

    public static Course dropStudent(Course course){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the name of student: ");
        String name = scanner.nextLine();
        Course.dropStudent(name, course);
        return course;
    }
}
