package com.atguigu.service.impl;

import com.atguigu.dao.CustomerDao;
import com.atguigu.domain.Customer;
import com.atguigu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    RedisTemplate redisTemplate;    //操作任何类型数据

    @Autowired
    StringRedisTemplate stringRedisTemplate;    //操作String类型

    /**
     * 查询所有
     */
    @Override
    public List<Customer> findCustomers() {

        String key = "allcustomer";
        List<Customer> list = (List<Customer>) redisTemplate.boundValueOps(key).get();
        if (list != null) {
            System.out.println("from redis list = " + list);
            return list;
        }

        list = customerDao.findAll();
        redisTemplate.boundValueOps(key).set(list);

        System.out.println("from mysql list = " + list);

        return list;
    }

    /**
     * 根据id查询
     */
    @Override
    public Customer findCustomerById(Integer id) {
        return customerDao.getOne(id);
    }

    /**
     * 保存
     */
    @Override
    public void saveCustomer(Customer customer) {
        customerDao.save(customer); //bean对象OID值为null就进行save操作
    }


    /**
     * 更新
     */
    @Override
    public void updateCustomer(Customer customer) {
        customerDao.save(customer); //bean对象有OID就进行update操作
    }

    /**
     * 根据id删除
     */
    @Override
    public void deleteCustomerById(Integer id) {
        customerDao.deleteById(id);
    }
}
