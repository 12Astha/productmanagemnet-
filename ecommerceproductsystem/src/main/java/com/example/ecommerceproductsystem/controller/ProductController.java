package com.example.ecommerceproductsystem.controller;

import com.example.ecommerceproductsystem.Entity.Product;
import com.example.ecommerceproductsystem.dto.ProductDTO;
import com.example.ecommerceproductsystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;



    @GetMapping
    public List<Product> getAll(){
        return service.getAllProduct();
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody ProductDTO dto)
        {
           return service.updateProduct(id, dto);

        }


        @DeleteMapping("/{id}")
         public String delete(@PathVariable  Long id)
        {
            service.deleteProduct(id);
            return "Deleted Successfully";
        }


       @PostMapping("/add/{userId}")
        public Product addProduct(@PathVariable Long userId,
                              @RequestBody ProductDTO dto) {
             return service.addProduct(dto, userId);
    }
    }
