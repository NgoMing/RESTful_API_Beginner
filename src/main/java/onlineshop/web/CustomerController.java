package onlineshop.web;

import onlineshop.Customer;
import onlineshop.data.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistration(Model model) {
        model.addAttribute(new Customer());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(Customer customer) {
        customerRepository.save(customer);
        return "redirect:/customer/" + customer.getUsername();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showCustomerProfile(@PathVariable String username, Model model) {
        Customer customer = customerRepository.findByUsername(username);
        model.addAttribute(customer);
        return "profile";
    }
}
