package onlineshop.db;

import onlineshop.domain.Customer;

public interface CustomerRepository {

    Customer save(Customer customer);

    Customer findByUsername(String username);
}
