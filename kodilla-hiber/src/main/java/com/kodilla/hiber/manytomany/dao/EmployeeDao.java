package com.kodilla.hiber.manytomany.dao;

import com.kodilla.hiber.manytomany.Employee;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
    @Query
    List<Employee> retrieveEmployeeByLastname(@Param("LASTNAME") String lastname);
}
