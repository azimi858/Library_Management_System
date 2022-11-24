package de.srh.LMS.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;
    private String surname;
    private String firstname;
    private String email;
    private Integer matriculationNumber;
    private LocalDate dateOfBirth;
    private int age;

    public static int totalUserNumber;

    public Student() {
    }

    // TODO: Convert dateOfBirth Datatype from frontend to LocalDate
    public Student(long id, String surname, String firstname, String email,
                   int matriculationNumber, LocalDate dateOfBirth) {
        this.id = id;
        this.surname = surname;
        this.firstname = firstname;
        this.email = email;
        this.matriculationNumber = matriculationNumber;
        this.dateOfBirth = dateOfBirth;
        this.age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        totalUserNumber++;
    }

    public Student(String surname, String firstname,
                   String email, int matriculationNumber,
                   LocalDate dateOfBirth) {
        this.surname = surname;
        this.firstname = firstname;
        this.email = email;
        this.matriculationNumber = matriculationNumber;
        this.dateOfBirth = dateOfBirth;
        this.age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        totalUserNumber++;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getMatriculationNumber() {
        return matriculationNumber;
    }

    public void setMatriculationNumber(Integer matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", email='" + email + '\'' +
                ", matriculationNumber=" + matriculationNumber +
                ", dateOfBirth=" + dateOfBirth +
                ", age=" + age +
                '}';
    }
}
