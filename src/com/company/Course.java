package com.company;

public class Course {
    private String name;
    private String[] students = new String[100];
    private int studentsCount = 0;

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String[] getStudents() {
        return students;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(int studentsCount) {
        this.studentsCount = studentsCount;
    }

    public void setStudents(String[] students) {
        this.students = students;
    }

    public void addStudent(String name) {
        if(getStudentsCount() < getStudents().length-1) {
            getStudents()[getStudentsCount()] = name;
            setStudentsCount(getStudentsCount() + 1);
        }else{
            String[] largerArray = new String[getStudents().length+1];
            for(int i = 0; i < getStudents().length; i++){
                largerArray[i] = getStudents()[i];
            }
            setStudents(largerArray);
            setStudentsCount(getStudents().length-1);
            getStudents()[getStudentsCount()] = name;
            setStudentsCount(getStudentsCount()+1);
        }
    }

    public void removeStudent(String name) {
        boolean found = false;
        for (int i = 0; i < getStudentsCount(); i++) {
            if (getStudents()[i] == name) {
                found = true;
                for (int j = i + 1; j < getStudentsCount(); j++) {
                    getStudents()[j - 1] = getStudents()[j];
                }
                setStudentsCount(getStudentsCount()-1);
                System.out.println("Student \"" + name + "\" removed!");
            }
        }
        if (!found) {
            System.out.println("Student \"" + name + "\" not existed in list, nothing removed!");
        }
    }

    public static void dropStudent(String name, Course course){
        boolean found = false;
        for(int i = 0; i < course.getStudentsCount(); i++){
            if(name.equals(course.getStudents()[i])){
                found = true;
                for(int j = i; j < course.getStudentsCount(); j++){
                    course.getStudents()[j] = course.getStudents()[j+1];
                }
                course.setStudentsCount(course.getStudentsCount()-1);
                System.out.println("Student \"" + name + "\" removed!");
            }
        }
        if(!found){
            System.out.println("Student \"" + name + "\" not existed in list, nothing removed!");
        }
    }

    public void clear(){
        String[] clearCourse = new String[getStudents().length];
        setStudents(clearCourse);
        setStudentsCount(0);
    }
}
