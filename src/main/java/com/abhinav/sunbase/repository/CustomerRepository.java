package com.abhinav.sunbase.repository;

import com.abhinav.sunbase.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

// This will be AUTO IMPLEMENTED by Spring into a Bean called customerRepository
public interface CustomerRepository extends CrudRepository<Customer, UUID> {

}
