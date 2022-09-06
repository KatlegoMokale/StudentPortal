package com.katlego.studentportal.myportal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role, Integer> {
    @Query("SELECT u FROM Role u WHERE u.name = :name")
    public Role findByName(String name);
}
