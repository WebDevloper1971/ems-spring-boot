package com.ems.starter.repositories;

import com.ems.starter.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface EmpRepo extends JpaRepository<Employee, Long>{

}
