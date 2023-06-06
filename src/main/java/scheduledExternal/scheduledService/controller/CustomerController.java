package scheduledExternal.scheduledService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import scheduledExternal.scheduledService.business.abstracts.CustomerService;
import scheduledExternal.scheduledService.business.dto.CustomerDto;

import java.util.List;

@RestController
@RequestMapping("/v1/baseCustomer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getAllBaseCustomer")
    public ResponseEntity<List<CustomerDto>> getAllCustomer() {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @GetMapping("/getAllCustomerWithVersion")
    public ResponseEntity<List<CustomerDto>> getAllCustomerWithVersion(@RequestParam("version") int versionNumber) {
        return ResponseEntity.ok(customerService.getAllCustomerWithVersion(versionNumber));
    }
}
