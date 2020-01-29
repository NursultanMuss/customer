package com.example.customerdata;

import com.example.customerdata.entity.Customer;
import com.example.customerdata.repos.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class CustomerdataApplicationTests {

    @Autowired
    CustomerRepository repository;
    @Test
    void contextLoads() {
    }

    @Test
    void testCreate(){
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Nurs");
        customer.setEmail("nursalga@gmail.com");

        repository.save(customer);
    }

    @Test
    void testRead(){
        if(repository.findById(1).isPresent()){
            Optional<Customer> customerOptional = repository.findById(1);
            Customer customer = customerOptional.get();
            System.out.println(customer.getId() + customer.getName()+ customer.getEmail());
        }
    }

    @Test
    void testUpdate(){
        if(repository.findById(1).isPresent()){
            Optional<Customer> customerOptional = repository.findById(1);
            Customer customer = customerOptional.get();
            customer.setName("Zhan");
            repository.save(customer);
        }
    }

    @Test
    void testDelete(){
        if(repository.findById(1).isPresent()){
            System.out.println("find note");
            repository.deleteById(1);
        }
    }

    @Test
    void testCount(){
        System.out.println("there is "+repository.count()+" notes");
    }

}
