package scheduledExternal.scheduledService.business.abstracts;

import scheduledExternal.scheduledService.business.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAllCustomer();
    List<CustomerDto> getAllCustomerWithVersion(int versionNumber);
}
