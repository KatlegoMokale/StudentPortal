package com.katlego.studentportal.myportal;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "Mokale";
        String endcodedPassword = encoder.encode(rawPassword);

        System.out.println(endcodedPassword);
    }
    
}
