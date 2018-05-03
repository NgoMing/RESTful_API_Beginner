package onlineshop.data;

import onlineshop.Customer;

public interface CustomerRepository {

    Customer save(Customer customer);

    Customer findByUsername(String username);
}
