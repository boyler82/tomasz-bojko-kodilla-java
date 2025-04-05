package com.kodilla.fasade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopService {
    private final List<Order> orders = new ArrayList<>();
    private final Authenticator authenticator;
    private final ProductService productService;
    @Autowired
    public ShopService(Authenticator authenticator, ProductService productService) {
        this.authenticator = authenticator;
        this.productService = productService;
    }
}
