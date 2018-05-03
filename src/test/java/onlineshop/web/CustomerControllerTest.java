package onlineshop.web;

import onlineshop.Customer;
import onlineshop.data.CustomerRepository;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class CustomerControllerTest {

    @Test
    public void shouldShowRegistration() throws Exception {

        CustomerRepository mockRepository = mock(CustomerRepository.class);
        CustomerController controller = new CustomerController(mockRepository);

        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/customer/register"))
                .andExpect(view().name("registerForm"));
    }

    @Test
    public void shouldProcessingRegistration() throws Exception {
        CustomerRepository mockRepository = mock(CustomerRepository.class);
        Customer unsaved = new Customer("minhnln", "123456a@", "Minh", "Ngo");
        Customer saved = new Customer(24L, "minhnln", "123456a", "Minh", "Ngo");
        when(mockRepository.save(unsaved)).thenReturn(saved);

        CustomerController controller = new CustomerController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/customer/register")
                .param("firstName", "Minh")
                .param("lastName", "Ngo")
                .param("username", "minhnln")
                .param("password", "123456a"))
                .andExpect(redirectedUrl("/customer/minhnln"));

        verify(mockRepository, atLeastOnce()).save(unsaved);
    }
}