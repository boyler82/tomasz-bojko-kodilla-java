package com.kodilla.hiber.invoice.dao;

import com.kodilla.hiber.invoice.Invoice;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface InvoiceDao extends CrudRepository<Invoice, Integer> {
}
