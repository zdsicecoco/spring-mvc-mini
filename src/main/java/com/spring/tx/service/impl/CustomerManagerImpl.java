package com.spring.tx.service.impl;

import com.spring.tx.dao.CustomerDAO;
import com.spring.tx.pojo.Customer;
import com.spring.tx.service.CustomerManager;
import org.springframework.transaction.annotation.Transactional;

public class CustomerManagerImpl implements CustomerManager {

    private CustomerDAO customerDAO;

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    @Transactional
    public void createCustomer(Customer cust) {
        customerDAO.create(cust);
    }

}
