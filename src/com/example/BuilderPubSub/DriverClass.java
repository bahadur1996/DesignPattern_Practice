package com.example.BuilderPubSub;

import java.util.ArrayList;

public class DriverClass {

    public static void main(String[] args) {

        //creating immutable department object
        Department department = Department.createNewDepartment(1l,"CSE",new ArrayList<>());

        //creating immutable student object using builder patter
        Student student1 = new Student.StudentBuilder(1l,"Bahadur",department).build();
        Student student2 = new Student.StudentBuilder(2l,"Arshad",department).build();

        //registering all students object as observers
        department.addObserver(student1);
        department.addObserver(student2);

        //publish notice in the department
        department.publishNotice("Notice test");

    }
}
