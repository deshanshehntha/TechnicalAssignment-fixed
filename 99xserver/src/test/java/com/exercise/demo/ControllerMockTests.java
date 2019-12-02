package com.exercise.demo;

import com.exercise.demo.dao.ProductRepository;
import com.exercise.demo.model.Product;
import com.exercise.demo.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerMockTests {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void testRetrieveStudentWithMockRepository() throws Exception {
        assertEquals(productRepository.getProductByProductName("Horseshoe").getProductName(),"Horseshoe");
        assertEquals(productRepository.getProductByProductName("PenguinEar").getProductName(),"PenguinEar");
    }
}