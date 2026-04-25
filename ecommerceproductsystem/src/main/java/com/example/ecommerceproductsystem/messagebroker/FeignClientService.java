package com.example.ecommerceproductsystem.messagebroker;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user-service", url = "http://localhost:8081")
public interface FeignClientService {

    @GetMapping("/users/{id}")
    Object getUserById(@PathVariable("id") Long id);
}
