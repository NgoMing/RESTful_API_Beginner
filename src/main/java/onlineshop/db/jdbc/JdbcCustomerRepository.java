package onlineshop.db.jdbc;

import onlineshop.db.CustomerRepository;
import onlineshop.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class JdbcCustomerRepository implements CustomerRepository{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcCustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Customer save(Customer customer) {
        Long id = customer.getId();
        if (id == null) {
            Long customerId = insertCustomerAndReturnId(customer);
            return new Customer(customerId, customer.getUsername(), customer.getPassword(),
                    customer.getFirstName(), customer.getLastName());
        }
        else {
            jdbcTemplate.update(
                    "update Customer set username=?, password=?, firstname=?, lastname=?",
                    customer.getUsername(),
                    customer.getPassword(),
                    customer.getFirstName(),
                    customer.getLastName(),
                    id);
        }
        return customer;
    }

    @Override
    public Customer findByUsername(String username) {
        return jdbcTemplate.queryForObject(
                "select id, username, password, firstname, lastname from Customer where username=?",
                new CustomerRowMapper(), username);
    }

    private long insertCustomerAndReturnId(Customer customer) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("CUSTOMER");
        jdbcInsert.setGeneratedKeyName("id");
        Map<String, Object> args = new HashMap<>();
        args.put("username", customer.getUsername());
        args.put("password", customer.getPassword());
        args.put("firstname", customer.getFirstName());
        args.put("lastname", customer.getLastName());
        long customerId = jdbcInsert.executeAndReturnKey(args).longValue();
        return customerId;
    }

    private static final class CustomerRowMapper implements RowMapper<Customer> {
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String firstName = rs.getString("firstname");
            String lastName = rs.getString("lastname");
            return new Customer(id, username, password, firstName, lastName);
        }
    }
}
