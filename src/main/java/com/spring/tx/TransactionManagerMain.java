package com.spring.tx;

import com.spring.tx.pojo.Address;
import com.spring.tx.pojo.Customer;
import com.spring.tx.service.CustomerManager;
import com.spring.tx.service.impl.CustomerManagerImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Created by wudong on 2017/1/23.
 */
public class TransactionManagerMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                "Spring-TX.xml");

        CustomerManager customerManager = ctx.getBean("customerManager",
                CustomerManagerImpl.class);

        Customer cust = createDummyCustomer();
        customerManager.createCustomer(cust);

        ctx.close();
    }

    private static Customer createDummyCustomer() {
        Customer customer = new Customer();
        customer.setId(2);
        customer.setName("Pankaj");
        Address address = new Address();
        address.setId(2);
        address.setCountry("India");
        // setting value more than 20 chars, so that SQLException occurs
        address.setAddress("Albany Dr, San Jose, CA 95129");
        customer.setAddress(address);
        return customer;
    }

}
