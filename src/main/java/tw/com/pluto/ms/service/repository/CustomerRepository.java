package tw.com.pluto.ms.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tw.com.pluto.ms.service.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
