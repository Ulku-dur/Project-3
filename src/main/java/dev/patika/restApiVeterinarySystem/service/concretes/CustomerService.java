package dev.patika.restApiVeterinarySystem.service.concretes;

import dev.patika.restApiVeterinarySystem.dto.request.CustomerRequest;
import dev.patika.restApiVeterinarySystem.dto.response.CustomerResponse;
import dev.patika.restApiVeterinarySystem.entity.Customer;
import dev.patika.restApiVeterinarySystem.exception.CustomerAlreadyExistsException;
import dev.patika.restApiVeterinarySystem.exception.IdNotFoundException;
import dev.patika.restApiVeterinarySystem.mapper.CustomerMapper;
import dev.patika.restApiVeterinarySystem.repository.CustomerRepository;
import dev.patika.restApiVeterinarySystem.service.abstracts.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public List<CustomerResponse> findAll() {
        return customerMapper.toResponse(customerRepository.findAll());
    }

    public CustomerResponse getById(Long id) {
        return customerMapper.toResponse(customerRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Pet owner with id " + id + " not found!")));
    }

    public CustomerResponse create (CustomerRequest request) {
        Optional<Customer> customerFromDb = customerRepository.findByMailAndName(request.getMail(), request.getName());
        if (customerFromDb.isPresent()) {
            throw new CustomerAlreadyExistsException(customerFromDb.get().getId());
        }
        Customer customerSaved = customerRepository.save(customerMapper.toEntity(request));
        return customerMapper.toResponse(customerSaved);

    }

    public CustomerResponse update(Long id, CustomerRequest request) {
        Optional<Customer> customerFromDb = customerRepository.findById(id);
        Optional<Customer> isCustomerExist = customerRepository.findByMailAndName(request.getMail(), request.getName());

        if (customerFromDb.isEmpty()) {
            throw new IdNotFoundException(id, request);
        }

        Customer customer = customerFromDb.get();
        customerMapper.update(customer, request);
        return customerMapper.toResponse((customerRepository.save(customer)));
    }

    public boolean deleteById(Long id) {
        if(customerRepository.existsById(id)){
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<CustomerResponse> findByName(String name) {
        return customerMapper.toResponse(customerRepository.findByName(name));
    }
}
