package com.kodilla.hiber.invoice.dao;

import com.kodilla.hiber.invoice.Invoice;
import com.kodilla.hiber.invoice.Item;
import com.kodilla.hiber.invoice.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private InvoiceDao invoiceDao;

    private Invoice ticketInvoice;
    private Product product;
    private Item item1;
    private Item item2;



    @BeforeEach
    void setup() {
        productDao.deleteAll();
        itemDao.deleteAll();
        invoiceDao.deleteAll();
    }

    @AfterEach
    void cleanup() {
        productDao.deleteAll();
        itemDao.deleteAll();
        invoiceDao.deleteAll();
    }

    @Test
    @Transactional
    void testInvoiceDaoSave() {
//        given
        product = new Product("Bus ticket");
        productDao.save(product);

        ticketInvoice = new Invoice("PKS invoice");
        invoiceDao.save(ticketInvoice);

        item1 = new Item(product, BigDecimal.valueOf(100), 1);
        item2 = new Item(product, BigDecimal.valueOf(50), 2);

        item1.setInvoice(ticketInvoice);
        item2.setInvoice(ticketInvoice);

        ticketInvoice.getItems().add(item1);
        ticketInvoice.getItems().add(item2);

        itemDao.save(item1);
        itemDao.save(item2);

        int invoiceId = ticketInvoice.getId();

//        then
        Optional<Invoice> retrievedInvoice = invoiceDao.findById(invoiceId);
        assertTrue(retrievedInvoice.isPresent());
        assertEquals(2, retrievedInvoice.get().getItems().size());
    }
}