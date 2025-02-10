package com.kodilla.hiber.manytomany.dao;

import com.kodilla.hiber.manytomany.Company;
import com.kodilla.hiber.manytomany.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @BeforeEach
    void setup() {
        companyDao.deleteAll();
        employeeDao.deleteAll();
    }

    @AfterEach
    void cleanup() {
        companyDao.deleteAll();
        employeeDao.deleteAll();
    }


    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    void testFindByFirstThreeLetters() {
        // given
        Company company1 = new Company("ABC Tech");
        Company company2 = new Company("ABC Solutions");
        Company company3 = new Company("XYZ Tech");

        companyDao.save(company1);
        companyDao.save(company2);
        companyDao.save(company3);

        // when
        List<Company> result = companyDao.findByFirstThreeLetters("ABC");

        // then
        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(c -> c.getName().equals("ABC Tech")));
        assertTrue(result.stream().anyMatch(c -> c.getName().equals("ABC Solutions")));
    }

    @Test
    void testFindByLastName() {
        // given
        Employee emp1 = new Employee("John", "Doe");
        Employee emp2 = new Employee("Jane", "Doe");
        Employee emp3 = new Employee("Alice", "Smith");

        employeeDao.save(emp1);
        employeeDao.save(emp2);
        employeeDao.save(emp3);

        // when
        List<Employee> result = employeeDao.retrieveEmployeeByLastname("Doe");

        // then
        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(e -> e.getFirstname().equals("John")));
        assertTrue(result.stream().anyMatch(e -> e.getFirstname().equals("Jane")));
    }

}
