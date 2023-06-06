package scheduledExternal.scheduledService.business.dto.converter;

import org.springframework.stereotype.Component;
import scheduledExternal.scheduledService.business.dto.CustomerDto;
import scheduledExternal.scheduledService.entities.Customer;

@Component
public class CustomerDtoConverter {

    public CustomerDto convertToCustomerDto(Customer customer) {
        return new CustomerDto(
                customer.getTckn(),
                customer.getName(),
                customer.getSurname(),
                customer.getAddress(),
                customer.getVersionNumber()
        );
        //throw new RuntimeException("deneme hatası");
    }

}
