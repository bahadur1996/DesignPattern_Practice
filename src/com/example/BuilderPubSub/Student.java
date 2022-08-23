package com.example.BuilderPubSub;

import java.util.Observable;
import java.util.Observer;

public final class Student implements Observer
{

    private final Long id;
    private final String name;
    private final Department department;

    private Student(StudentBuilder studentBuilder)
    {
        this.id= studentBuilder.id;
        this.name=studentBuilder.name;
        this.department= studentBuilder.department;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    //this method executes if any notice is published in the department class
    @Override
    public void update(Observable observable, Object notice) {
        System.out.println("Student "+this.id+" got the new notice : " + notice);

    }

    //builder class to create immutable student object
    public static class StudentBuilder
    {
        private Long id;
        private String name;
        private Department department;
        public StudentBuilder(Long id, String name, Department department)
        {
            this.id= id;
            this.name=name;
            this.department=department;
        }

        public StudentBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder setDepartment(Department department) {
            this.department = department;
            return this;
        }

        //method to create immutable Student object
        public Student build() {
            Student student =  new Student(this);
            return student;
        }

    }

}

