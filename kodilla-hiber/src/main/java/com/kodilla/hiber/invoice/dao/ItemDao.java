package com.kodilla.hiber.invoice.dao;

import com.kodilla.hiber.invoice.Item;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ItemDao extends CrudRepository<Item, Integer> {
}
