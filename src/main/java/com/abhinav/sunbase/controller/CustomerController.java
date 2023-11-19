package com.abhinav.sunbase.controller;

import com.abhinav.sunbase.exceptions.CustomerNotFoundException;
import com.abhinav.sunbase.model.Customer;
import com.abhinav.sunbase.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path ="/sunbase/portal/api/assignment.jsp")
public class CustomerController {
    private final CustomerRepository repository;

    CustomerController(CustomerRepository repository){
        this.repository = repository;
    }

    @GetMapping("/get_customer_list")
    @ResponseBody List<Customer> getAllCustomer() {
        return (List<Customer>) repository.findAll();
    }

    @GetMapping("/customer/{id}")
    @ResponseBody Customer getOneCustomer(@PathVariable UUID id){
        return repository.findById(id).orElseThrow(()-> new CustomerNotFoundException(id));
    }

    @PostMapping("/create")
    @ResponseBody Customer addNewCustomer(@RequestBody Customer newCustomer){
        return repository.save(newCustomer);
    }

    @DeleteMapping("/delete/{id}")
    void deleteCustomer(@PathVariable UUID id){
        repository.deleteById(id);
    }

    @PutMapping("/update/{id}")
    @ResponseBody Customer updateCustomer(@RequestBody Customer newCustomer, @PathVariable UUID id){
        return repository.findById(id).map(customer ->  {
            customer.setFirst_name(newCustomer.getFirst_name());
            customer.setLast_name(newCustomer.getLast_name());
            customer.setAddress(newCustomer.getAddress());
            customer.setCity(newCustomer.getCity());
            customer.setStreet(newCustomer.getStreet());
            customer.setPhone(newCustomer.getPhone());
            return repository.save(customer);
        }).orElseGet(()->{
            newCustomer.setId(id);
            return repository.save(newCustomer);
        });
    }

}
