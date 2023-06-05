package scheduledExternal.scheduledService.business.concretes;

import org.springframework.stereotype.Service;
import scheduledExternal.scheduledService.business.abstracts.CustomerService;
import scheduledExternal.scheduledService.business.responses.GetAllCustomersResponse;
import scheduledExternal.scheduledService.dataAccess.CustomerRepository;
import scheduledExternal.scheduledService.entities.Customer;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerManager(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<GetAllCustomersResponse> getAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        List<GetAllCustomersResponse> getAllCustomersResponses =
                customers.stream().map(customer -> new GetAllCustomersResponse(
                        customer.getId(),
                        customer.getTckn(),
                        customer.getName(),
                        customer.getSurname(),
                        customer.getAddress(),
                        customer.getVersionNumber()
                )).collect(Collectors.toList());

        return getAllCustomersResponses;
    }
}

