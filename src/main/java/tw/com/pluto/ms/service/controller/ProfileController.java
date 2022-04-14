package tw.com.pluto.ms.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tw.com.pluto.ms.service.model.Customer;
import tw.com.pluto.ms.service.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class ProfileController {


    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('create_profile')")
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
    public Customer fetch(@PathVariable(value = "id") int profileId) {
        return customerService.fetchById(profileId);
    }

    @RequestMapping(value = "/profiles", method = RequestMethod.GET)
//    @PreAuthorize("hasAuthority('read_profile')")
//    @PreAuthorize("hasRole('ROLE_operator')") // 這樣設定只有具有 ROLE_operator 角色才可操作，就算是管理者角色也無法操作
    @PreAuthorize("hasRole('ROLE_admin')")
    public List<Customer> fetch() {
        return customerService.fetchAllProfiles();
    }
}