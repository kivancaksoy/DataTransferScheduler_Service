package scheduledExternal.scheduledService.business.abstracts;

import scheduledExternal.scheduledService.business.responses.GetAllCustomersResponse;

import java.util.List;

public interface CustomerService {
    List<GetAllCustomersResponse> getAllCustomer();
}
