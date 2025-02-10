package com.kodilla.hiber.manytomany.dao;

import com.kodilla.hiber.manytomany.Company;
import jakarta.transaction.Transactional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {
    @Query(name = "Company.findByFirstThreeLetters")
    List<Company> findByFirstThreeLetters(@Param("prefix") String prefix);
}

