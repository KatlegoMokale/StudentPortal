package com.katlego.studentportal.myportal;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.katlego.studentportal.myportal.Admin.Registration;
import com.katlego.studentportal.myportal.Admin.UserRepository;
import com.katlego.studentportal.myportal.Students.StudentRepo;
import com.katlego.studentportal.myportal.Students.Students;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repo;

    @Autowired 
    private StudentRepo studentRepo;

    @Autowired
    private RoleRepo roleRepo;


    @Test
    public void testCreateUser(){

        String studentR = "Admin";

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "123456";
        String endcodedPassword = encoder.encode(rawPassword);

        String nameVal = "Palesa";
        String address = "10 Bluemoon st, Vanderbijlpark";
        String email = nameVal+"@gmail.com";


        Registration user = new Registration();
        user.setName(nameVal);
        user.setPassword(endcodedPassword);
        user.setEmail(email);
        user.setEnabled(true);

       
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepo.findByName(studentR));

        user.setRoles(roles);
     
        Registration savedUser = repo.save(user);

        Registration existUser = entityManager.find(Registration.class, savedUser.getId());

       assertThat(user.getName()).isEqualTo(existUser.getName());
        
       if(studentR=="Student"){
        
        Students student = new Students();
        student.setStudent_name(nameVal);
        student.setStudent_address(address);
        student.setStudent_password(endcodedPassword);
        student.setStudent_email(email);

        
        Students savedStudent = studentRepo.save(student);

        Students existStudent = entityManager.find(Students.class, savedStudent.getStudent_id());

        assertThat(student.getStudent_name()).isEqualTo(existStudent.getStudent_name());

       }

    }

    // @Test
    // public void testFindUserByEmail(){
    //     String username = "Blackie";

    //     User user = repo.findByEmail(username);

    //     assertThat(user).isNotNull();
    // }

}
