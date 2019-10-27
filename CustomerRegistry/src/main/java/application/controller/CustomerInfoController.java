package application.controller;

import application.annotation.SaveRequestInDatabase;
import application.domain.Customer;
import application.enumerate.RequestTypeEnum;
import application.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/customer/info/")
public class CustomerInfoController {

    @Autowired
    CustomerRepository customerRepository;

    @SaveRequestInDatabase(requestType = RequestTypeEnum.CUSTOMER_COUNT)
    @GetMapping("count")
    public ResponseEntity<Long> getCustomerCount(){
        return ResponseEntity.status(HttpStatus.OK).body(customerRepository.count());
    }

}
