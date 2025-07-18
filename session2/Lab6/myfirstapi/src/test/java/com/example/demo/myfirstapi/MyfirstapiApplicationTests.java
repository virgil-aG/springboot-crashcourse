package com.example.demo.myfirstapi;

import com.example.demo.myfirstapi.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyfirstapiApplicationTests {
	Product product;

	@BeforeEach
	void setup(){
		product = new Product(1L,"Milk", 50.00);
	}

	@Test
	void getIdTest(){
		assertEquals(1L,product.getId());
	}

	@Test
	void getNameTest(){
		assertEquals("Milk",product.getName());
	}

	@Test
	void getPriceTest(){
		assertEquals(50.00,product.getPrice());
	}

	@Test
	void setIdTest(){
		product.setId(2L);
		assertEquals(2L,product.getId());
	}

	@Test
	void setNameTest(){
		product.setName("Banana");
		assertEquals("Banana",product.getName());
	}

	@Test
	void setPriceTest(){
		product.setPrice(20.00);
		assertEquals(20.00,product.getPrice());
	}

	@Test
	void contextLoads() {
	}

}
