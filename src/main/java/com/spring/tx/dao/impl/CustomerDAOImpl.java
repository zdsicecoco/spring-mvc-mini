package com.spring.tx.dao.impl;

import com.spring.tx.dao.CustomerDAO;
import com.spring.tx.pojo.Customer;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class CustomerDAOImpl implements CustomerDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void create(Customer customer) {
        String queryCustomer = "insert into Customer (id, name) values (?,?)";
        String queryAddress = "insert into Address (id, address,country) values (?,?,?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(queryCustomer, new Object[] { customer.getId(),
                customer.getName() });
        System.out.println("Inserted into Customer Table Successfully");
        jdbcTemplate.update(queryAddress, new Object[] { customer.getId(),
                customer.getAddress().getAddress(),
                customer.getAddress().getCountry() });
        System.out.println("Inserted into Address Table Successfully");
    }

}
