package com.katlego.studentportal.myportal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.katlego.studentportal.myportal.Admin.Registration;
import com.katlego.studentportal.myportal.Admin.UserRepository;
import com.katlego.studentportal.myportal.Students.StudentRepo;
import com.katlego.studentportal.myportal.Students.StudentServices;
import com.katlego.studentportal.myportal.Students.Students;




@Controller
public class AppController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private RegistrationRepo registrationRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private StudentServices service;

    @Autowired
    private RoleRepo roleRepo;

    // @GetMapping("")
    // public String viewHomePage(){
    //     return "index";
    // }
    
    // @GetMapping("/register")
    // public String showRegistrationForm(Model model) {
    //     model.addAttribute("user", new User());
    //     return "admin/signup";
    // }

    // @PostMapping("/process_register")
    // public String processRegister(User user) {
    //     BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    //     String encodedPassword = encoder.encode(user.getAdmin_password());
    //     user.setAdmin_password(encodedPassword);

    //     repo.save(user);

    //     return "student/register_success";
       
    // }

    // @GetMapping("/admin/login")
    // public String viewAdminLoginPage() {
    //     return "admin/admin_login";
    // }


    @GetMapping("/student/")
    public String viewUserLoginPage() {
        return "student/student_login";
    }

    @GetMapping("/admin/registerstudent")
    public String showRegistrationFormStudent(Model model) {
        model.addAttribute("userR", new Students());
        return "/admin/studentregister";
    }

    @PostMapping("/process_register_student")
    public String processRegisterStudent(Students userR) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(userR.getStudent_password());
        userR.setStudent_password(encodedPassword);


        String userName = userR.getStudent_name();
        String userPassword = encodedPassword;
        String userEmail = userR.getStudent_email();
        String userAddress = userR.getStudent_address();

        Students student = new Students();
        student.setStudent_name(userName);
        student.setStudent_password(userPassword);
        student.setStudent_email(userEmail);
        student.setStudent_address(userAddress);
        
        studentRepo.save(student);

        Registration user = new Registration();
        user.setName(userName);
        user.setPassword(userPassword);
        user.setEmail(userEmail);
        user.setEnabled(true);

    
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepo.findByName("Student"));

        user.setRoles(roles);
     
        repo.save(user);

        return "redirect:/";
       
    }

    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/")
    public String viewStudentMarks(Model model){
        List<Students> listStudent = service.listAll();
		model.addAttribute("listStudent",listStudent);
		return "index";
    }

    @GetMapping("/login")
    public String viewLogin(){
		return "/login";
    }

    @RequestMapping("/new")
	public String newStudentPage(Model model) {
		Students student=new Students();
		model.addAttribute(student);
		return "/admin/studentregister";
	}
	
	@RequestMapping(value = "/save", method =RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student") Students student ) {
        // if(student.getStudent_password().length()<=40){
        //     BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //     String encodedPassword = encoder.encode(student.getStudent_password());
        //     student.setStudent_password(encodedPassword);
        // }
		service.save(student);
		return "redirect:/";
	}

	@RequestMapping("/edit/{student_id}")
	public ModelAndView showEditStudentPage(@PathVariable(name = "student_id") Long student_id) {
        

        ModelAndView mav=new ModelAndView("admin/edit_student");
		Students student=service.get(student_id);
		mav.addObject("student",student);
		return mav;
	}
	
	@RequestMapping("/delete/{student_id}")
	public String deleteStudentPage(@PathVariable (name="student_id") Long student_id) {
		service.delete(student_id);
		return "redirect:/";
	}

    // @GetMapping("/index")
    // public String viewUsersList(Model model){

    //     List<User> listOfUsers = repo.findAll();
    //     model.addAttribute("listOfUsers", listOfUsers);

    //     return "admin/userslist";
    // }
    
}
