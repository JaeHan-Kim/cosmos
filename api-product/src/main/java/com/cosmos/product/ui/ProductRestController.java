package com.cosmos.product.ui;

import com.cosmos.product.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

    private Logger log = LoggerFactory.getLogger(ProductRestController.class);

    @GetMapping
    public ResponseEntity<Product> findProduct() {
        UUID id = UUID.randomUUID();
        String name = "상품";
        BigDecimal price = BigDecimal.valueOf(15000L);

        log.info("product id {}", id);

        Product product = new Product(id, name, price);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/hostName")
    public String test() {
        String podName = Optional.ofNullable(System.getenv("HOSTNAME")).orElse("null");
        return podName;
    }
}
