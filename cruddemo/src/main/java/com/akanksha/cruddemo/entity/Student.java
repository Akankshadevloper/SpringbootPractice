package com.akanksha.cruddemo.entity;


import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {

    //define field
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;


    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String emailName;




    //define constructor
    public Student(){

    }

    public Student(String firstName, String lastName, String emailName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailName = emailName;
    }
    //define getter/setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailName() {
        return emailName;
    }

    public void setEmailName(String emailName) {
        this.emailName = emailName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    //define toString() method


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailName='" + emailName + '\'' +
                '}';
    }
}
