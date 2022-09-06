package com.katlego.studentportal.myportal.Students;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentServices {
    
    @Autowired
    private StudentRepo repo;

    public List<Students> listAll(){
        return repo.findAll();
    }

    public void save(Students student){
        repo.save(student);
    }

    public Students get(Long student_id) {
		return repo.findById(student_id).get();
	}
	
	public void delete(Long student_id) {
		repo.deleteById(student_id);
	}


}
