package onlineshop.data;

import onlineshop.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    List<Customer> listCustomer = new ArrayList<>();

    @Override
    public Customer save(Customer customer) {
        listCustomer.add(customer);
        return customer;
    }

    @Override
    public Customer findByUsername(String username) {

        Customer returnedCustomer= null;

        for (Customer customer: listCustomer) {
            if (customer.getUsername().equals(username)) {
                returnedCustomer = customer;
            }
        }

        return returnedCustomer;
    }
}
