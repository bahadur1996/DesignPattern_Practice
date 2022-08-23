package com.example.BuilderPubSub;

import java.util.List;
import java.util.Observable;

public final class Department extends Observable
{
    private final Long id;
    private final String name;
    private final List<Student> students;

    private Department(Long id, String name,List<Student> students)
    {
        this.id= id;
        this.name=name;
        this.students=students;
    }

    public static Department createNewDepartment(Long id, String name,List<Student> students)
    {
        return new Department(id, name, students);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    //this method notifies all registered students
    public void publishNotice(String notice){
        setChanged();
        notifyObservers(notice);
    }

}
