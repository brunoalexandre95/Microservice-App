package application.service;

import application.annotation.SaveRequestInDatabase;
import application.domain.Customer;
import application.enumerate.RequestTypeEnum;
import application.event.CustomerRegisteredEvent;
import application.event.EventDispatcher;
import application.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
class CustomerCreationServiceImpl implements CustomerCreationService {

    @Autowired
    CustomerRepository userRepository;

    @Autowired
    EventDispatcher eventDispatcher;

    @SaveRequestInDatabase(requestType = RequestTypeEnum.CREATION)
    @Override
    public Customer createNewCustomer(Customer newCustomer) {
        Customer customer = userRepository.save(newCustomer);
        CustomerRegisteredEvent event = new CustomerRegisteredEvent(customer.getId(), customer.getFirstName());
        eventDispatcher.send(event);
        return customer;
    }
}
