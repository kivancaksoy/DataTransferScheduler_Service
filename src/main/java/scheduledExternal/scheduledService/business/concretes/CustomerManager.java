package scheduledExternal.scheduledService.business.concretes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import scheduledExternal.scheduledService.business.abstracts.CustomerService;
import scheduledExternal.scheduledService.business.dto.CustomerDto;
import scheduledExternal.scheduledService.business.dto.converter.CustomerDtoConverter;
import scheduledExternal.scheduledService.dataAccess.CustomerRepository;
import scheduledExternal.scheduledService.entities.Customer;

import java.util.List;

@Service
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;
    private final Logger logger = LoggerFactory.getLogger(CustomerManager.class);

    public CustomerManager(CustomerRepository customerRepository, CustomerDtoConverter customerDtoConverter) {
        this.customerRepository = customerRepository;
        this.customerDtoConverter = customerDtoConverter;
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        return getAllCustomerDto(customers);
    }

    @Override
    public List<CustomerDto> getAllCustomerWithVersion(int versionNumber) {
        List<Customer> customers = customerRepository.findByVersionNumberGreaterThanEqual(versionNumber);

        return getAllCustomerDto(customers);

    }

    private List<CustomerDto> getAllCustomerDto(List<Customer> customers) {
        try {
            List<CustomerDto> customerDtos =
                    customers.stream().map(customerDtoConverter::convertToCustomerDto).toList();
            logger.info("Customers listed.");
            return customerDtos;
        } catch (Exception exception) {
            logger.error("An error occurred while listing: " + exception.getMessage());
        }
        return null;
    }
}

