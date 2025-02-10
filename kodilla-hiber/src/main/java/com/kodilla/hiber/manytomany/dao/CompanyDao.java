package com.kodilla.hiber.manytomany.dao;

import com.kodilla.hiber.manytomany.Company;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {

}

