package application.controller;

import application.annotation.SaveRequestInDatabase;
import application.domain.Customer;
import application.enumerate.RequestTypeEnum;
import application.service.CustomerCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/customer/creation/")
class CustomerCreationController {

    @Autowired
    private CustomerCreationService customerCreationService;

    @SaveRequestInDatabase(requestType = RequestTypeEnum.CREATION)
    @PostMapping("create")
    public ResponseEntity<Customer> createNewCustomer(@RequestBody Customer newCustomer){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerCreationService.createNewCustomer(newCustomer));
    }

    @PostMapping("add-address/${customerId}")
    public ResponseEntity<Address> addNewAddress()


}
