package com.katlego.studentportal.myportal.Admin;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Registration, Long> {

    @Query("SELECT u FROM Registration u WHERE u.email = :email")
    public Registration getUserByEmail(String email);
}
