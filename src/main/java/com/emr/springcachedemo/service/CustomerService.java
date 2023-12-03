package com.emr.springcachedemo.service;

import com.emr.springcachedemo.pojo.Customer;
import com.emr.springcachedemo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

//@Cacheable: cache'i kontrol et ve yoksa gidip methodu çağırarak cache'e yaz. aynı zamanda ban dön.
//@CachePut: cache'te olsa bile gidip metodu çağır bana dön ve aynı zamanda cache'e yaz
//@CacheEvict:

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

//
//    public String getCustomerAddress(Long customerId) {
//
//        Customer customer = customerRepository.findById(customerId).orElseThrow();
//
//        return getAddress(customer);
//    }

    @Cacheable("addresses")
    public String getAddress(Long customerId) {
        log.info("getAddress method worked...");
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        return customer.getAddress();
    }
}
