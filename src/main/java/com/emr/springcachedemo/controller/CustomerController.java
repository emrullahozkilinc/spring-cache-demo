package com.emr.springcachedemo.controller;

import com.emr.springcachedemo.pojo.Customer;
import com.emr.springcachedemo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/address/{id}")
    public ResponseEntity<String> getAddress(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getAddress(id));
    }
}
