package com.example.mongodemo.core.documententity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "student_dtl")
public class StudentDetailDocumentEntity {

    @Id
    private String id;

    private String rollNo;

    private String studentName;

    private Date dateOfBirth;

    private String branch;

    private String section;

    private int year;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "StudentDetailDocumentEntity{" +
                "id='" + id + '\'' +
                ", rollNo='" + rollNo + '\'' +
                ", studentName='" + studentName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", branch='" + branch + '\'' +
                ", section='" + section + '\'' +
                ", year=" + year +
                '}';
    }
}
