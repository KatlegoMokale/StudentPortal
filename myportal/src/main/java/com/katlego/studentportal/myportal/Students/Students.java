package com.katlego.studentportal.myportal.Students;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_id;

    @Column(nullable = false, length = 20)
    private String student_name;

    @Column(nullable = false, length = 100)
    private String student_address;

    @Column(nullable = false, length = 45, unique = true)
    private String student_email;

    @Column(nullable = false, length = 200)
    private String student_password;


    public Long getStudent_id() {
        return student_id;
    }


    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }


    public String getStudent_name() {
        return student_name;
    }


    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }


    public String getStudent_address() {
        return student_address;
    }


    public void setStudent_address(String student_address) {
        this.student_address = student_address;
    }


    public String getStudent_email() {
        return student_email;
    }


    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }


    public String getStudent_password() {
        return student_password;
    }


    public void setStudent_password(String student_password) {
        this.student_password = student_password;
    }


    public Students() {
        
    }


    
}
