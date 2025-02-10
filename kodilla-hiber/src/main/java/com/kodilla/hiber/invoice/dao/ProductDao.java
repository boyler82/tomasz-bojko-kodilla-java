    package com.kodilla.hiber.invoice.dao;

    import com.kodilla.hiber.invoice.Product;
    import jakarta.transaction.Transactional;
    import org.springframework.data.repository.CrudRepository;
    import org.springframework.stereotype.Repository;


    @Transactional
    @Repository
    public interface ProductDao extends CrudRepository<Product, Integer> {
    }
