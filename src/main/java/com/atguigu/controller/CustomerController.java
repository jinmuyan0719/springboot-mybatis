package com.atguigu.controller;

import com.atguigu.domain.Customer;
import com.atguigu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController     //@Controller 和 @ResponseBody 组合
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("/findAll")
    public List<Customer> findAll() {
        List<Customer> customers = customerService.findCustomers();
        System.out.println(customers);
        return customers;
    }
}
