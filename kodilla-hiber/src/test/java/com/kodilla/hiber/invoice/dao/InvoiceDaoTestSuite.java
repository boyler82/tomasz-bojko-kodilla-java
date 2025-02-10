package com.kodilla.hiber.invoice.dao;

import com.kodilla.hiber.invoice.Item;
import com.kodilla.hiber.invoice.Product;
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

    private Product product;
    private Item item1;
    private Item item2;



    @BeforeEach
    void setup() {
        productDao.deleteAll();
        itemDao.deleteAll();
    }

    @AfterEach
    void cleanup() {
        productDao.deleteAll();
        itemDao.deleteAll();
    }

    @Test
    void testInvoiceDaoSave() {
//        given
        product = new Product("Bus ticket");
        item1 = new Item(product, BigDecimal.valueOf(100), 1);
        item2 = new Item(product, BigDecimal.valueOf(100), 2);
//        when
        product.getItems().add(item1);
        product.getItems().add(item2);
        productDao.save(product);
        int productId = product.getId();
//        then

        Optional<Product> retrievedProduct = productDao.findById(productId);
        assertTrue(retrievedProduct.isPresent());
        assertEquals("Bus ticket", retrievedProduct.get().getName());
//        assertEquals(200, retrievedProduct.get().getItems().get(1).getValue()); czemu nie moge tego sprawdzic?



    }
}
