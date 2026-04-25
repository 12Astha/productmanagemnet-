package com.example.ecommerceproductsystem.service;

import com.example.ecommerceproductsystem.Entity.Product;

import com.example.ecommerceproductsystem.dto.ProductDTO;
import com.example.ecommerceproductsystem.messagebroker.FeignClientService;
import com.example.ecommerceproductsystem.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class ProductService {


    private ProductRepository repo;


    private FeignClientService fiegnclient;




    public Product addProduct(ProductDTO dto,Long userId)
    {
        Product p = new Product();
        p.setName(dto.getName());
        p.setPrice(dto.getPrice());
        return repo.save(p);
    }
    public List<Product> getAllProduct(){
        return repo.findAll();

    }
    public Product updateProduct(Long id, ProductDTO dto){
        Product p = repo.findById(id).orElseThrow();
        p.setName(dto.getName());
        p.setPrice(dto.getPrice());
        return repo.save(p);

    }
    public void deleteProduct(Long id)
    {
        repo.deleteById(id);
    }


}
