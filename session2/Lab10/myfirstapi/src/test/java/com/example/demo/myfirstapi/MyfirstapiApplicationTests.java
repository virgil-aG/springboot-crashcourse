package com.example.demo.myfirstapi;

import com.example.demo.myfirstapi.model.Product;
import com.example.demo.myfirstapi.repository.ProductRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyfirstapiApplicationTests {
	ProductRepository productRepository = new ProductRepository();
	static List<Product> products = new ArrayList<>();
	static AtomicLong nextId = new AtomicLong(1);

	@BeforeAll
    static void setup(){
		products.add(new Product(nextId.getAndIncrement(), "Laptop", 1200.00));
		products.add(new Product(nextId.getAndIncrement(), "Mouse", 25.50));
		products.add(new Product(nextId.getAndIncrement(), "Keyboard", 75.00));
	}

	@Test
	void findIdTest() {
        Optional<Product> optionalProduct = productRepository.findById(1L);

        Product actualProduct = null;
        if (optionalProduct.isPresent()) {
            actualProduct = optionalProduct.get();
        }

        assertEquals(products.getFirst(), actualProduct);
    }

	@Test
	void findAllTest(){
		assertEquals(products,productRepository.findAll());
	}

	@Test
	void saveTest(){
		Product product = new Product("Speaker", 500.00);
		productRepository.save(product);
		Optional<Product> optionalProduct = productRepository.findById(4L);

		Product actualProduct = null;
		if (optionalProduct.isPresent()) {
			actualProduct = optionalProduct.get();
		}

		assertEquals(product, actualProduct);
	}

	@Test
	void contextLoads() {
	}



}
