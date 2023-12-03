package com.emr.springcachedemo.repository;

import com.emr.springcachedemo.pojo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
