package scheduledExternal.scheduledService.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import scheduledExternal.scheduledService.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
