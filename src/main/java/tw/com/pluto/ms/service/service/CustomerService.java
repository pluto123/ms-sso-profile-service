package tw.com.pluto.ms.service.service;

import tw.com.pluto.ms.service.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);
    Customer fetchById(int profileId);
    List<Customer> fetchAllProfiles();
}
