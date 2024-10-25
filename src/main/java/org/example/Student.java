package org.example;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    private Integer id;
    private String name;
    private String city;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", city='" + this.city + '\'' +
                '}';
    }

    public Student(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Student() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
