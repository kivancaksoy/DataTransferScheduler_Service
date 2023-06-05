package scheduledExternal.scheduledService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scheduledExternal.scheduledService.business.abstracts.CustomerService;
import scheduledExternal.scheduledService.business.responses.GetAllCustomersResponse;

import java.util.List;

@RestController
@RequestMapping("/v1/baseCustomer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getAllBaseCustomer")
    public ResponseEntity<List<GetAllCustomersResponse>> getAllCustomer() {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }
}
