package dev.patika.restApiVeterinarySystem.service.abstracts;

import dev.patika.restApiVeterinarySystem.dto.request.CustomerRequest;
import dev.patika.restApiVeterinarySystem.dto.response.CustomerResponse;

import java.util.List;

public interface ICustomerService {
    List<CustomerResponse> findAll();
    CustomerResponse getById(Long id);
    CustomerResponse create (CustomerRequest request);
    CustomerResponse update(Long id, CustomerRequest request);
    boolean deleteById(Long id);
    List<CustomerResponse> findByName(String name);
}
