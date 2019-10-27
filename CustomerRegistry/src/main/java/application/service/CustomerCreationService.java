package application.service;


import application.domain.Customer;

public interface CustomerCreationService {

    Customer createNewCustomer(Customer newCustomer);
}
