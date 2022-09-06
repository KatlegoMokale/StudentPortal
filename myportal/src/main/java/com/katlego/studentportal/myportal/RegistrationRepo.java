package com.katlego.studentportal.myportal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.katlego.studentportal.myportal.Admin.Registration;

public interface RegistrationRepo extends JpaRepository<Registration, Long> {
    
}
