// package com.katlego.studentportal.myportal;

// import javax.sql.DataSource;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.core.annotation.Order;
// import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// @Configuration
// @Order(2)
// @EnableWebSecurity
// public class studentSecurityConfig extends WebSecurityConfigurerAdapter {

//     @Autowired
//     private DataSource dataSource;
     
//     @Bean
//     public UserDetailsService studentDetailsService() {
//         return new CustomStudentDetailsService();
//     }
     
//     @Bean
//     public BCryptPasswordEncoder passwordEncoder1() {
//         return new BCryptPasswordEncoder();
//     }
     
//     @Bean
//     public DaoAuthenticationProvider authenticationProvider2() {
//         DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//         authProvider.setUserDetailsService(studentDetailsService());
//         authProvider.setPasswordEncoder(passwordEncoder1());
         
//         return authProvider;
//     }
 
//     @Override
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//         auth.authenticationProvider(authenticationProvider2());
//     }
 
//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http.authorizeRequests()
//             .antMatchers("/student/portal").authenticated()
//             .anyRequest().permitAll()
//             .and()
//             .formLogin()
//             .loginPage("/student/login")
//                             .usernameParameter("student_email")
//                             .loginProcessingUrl("/student/login")
//                             .defaultSuccessUrl("/student/studentportal")
//             .and()
//             .logout().logoutSuccessUrl("/").permitAll();
//     }
     


//     // @Bean
//     // public UserDetailsService studentUserDetailsService() {
//     //     return new CustomStudentDetailsService();
//     // }
 
//     // @Bean
//     // public BCryptPasswordEncoder passwordEncoder2() {
//     //     return new BCryptPasswordEncoder();
//     // }
     
 
//     // @Bean
//     // public DaoAuthenticationProvider authenticationProvider2() {
//     //     DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//     //     authProvider.setUserDetailsService(studentUserDetailsService());
//     //     authProvider.setPasswordEncoder(passwordEncoder2());
 
//     //     return authProvider;
//     // }
 
//     // @Override
//     // public void configure(HttpSecurity http) throws Exception {
//     //     http.authenticationProvider(authenticationProvider2());
 
//     //     http.antMatcher("/student/**")
//     //         .authorizeRequests().anyRequest().authenticated()
//     //         .and()
//     //             .formLogin()
//     //                 .loginPage("/student/login")
//     //                 .usernameParameter("student_email")
//     //                 .loginProcessingUrl("/student/login")
//     //                 .defaultSuccessUrl("/student/studentportal")
//     //             .permitAll()
//     //         .and()
//     //             .logout()
//     //                 .logoutSuccessUrl("/");
//     // }
    
// }
