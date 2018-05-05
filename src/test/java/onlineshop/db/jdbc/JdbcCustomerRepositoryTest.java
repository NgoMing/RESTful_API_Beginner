package onlineshop.db.jdbc;

import onlineshop.config.jdbc.JdbcConfig;
import onlineshop.domain.Customer;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=JdbcConfig.class)
public class JdbcCustomerRepositoryTest {

    @Autowired
    JdbcCustomerRepository customerRepository;

    @Test
    @Transactional
    public void save_newCustomer() {
        Customer customer = new Customer(null, "newbee", "letmein", "New", "Bee");
        Customer saved = customerRepository.save(customer);
        assertCustomer(4, saved);
        assertCustomer(4, customerRepository.findByUsername("newbee"));
    }

    @Test
    @Transactional
    public void findByUsername() {
        assertCustomer(0, customerRepository.findByUsername("habuma"));
        assertCustomer(1, customerRepository.findByUsername("mwalls"));
        assertCustomer(2, customerRepository.findByUsername("chuck"));
        assertCustomer(3, customerRepository.findByUsername("artnames"));
    }

    private static void assertCustomer(int expectedCustomerIndex, Customer actual) {
        Customer expected = CUSTOMER[expectedCustomerIndex];
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getUsername(), actual.getUsername());
        assertEquals(expected.getPassword(), actual.getPassword());
        assertEquals(expected.getFirstName(), actual.getFirstName());
        assertEquals(expected.getLastName(), actual.getLastName());
    }

    private static Customer[] CUSTOMER = new Customer[6];

    @BeforeClass
    public static void before() {
        CUSTOMER[0] = new Customer(1L, "habuma", "password", "Craig", "Walls");
        CUSTOMER[1] = new Customer(2L, "mwalls", "password", "Michael","Walls");
        CUSTOMER[2] = new Customer(3L, "chuck", "password", "Chuck", "Wagon");
        CUSTOMER[3] = new Customer(4L, "artnames", "password", "Art", "Names");
        CUSTOMER[4] = new Customer(5L, "newbee", "letmein", "New", "Bee");
        CUSTOMER[5] = new Customer(4L, "arthur", "letmein", "Arthur", "Names");
    }
}