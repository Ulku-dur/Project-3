package dev.patika.restApiVeterinarySystem.mapper;

import dev.patika.restApiVeterinarySystem.dto.request.CustomerRequest;
import dev.patika.restApiVeterinarySystem.dto.response.CustomerResponse;
import dev.patika.restApiVeterinarySystem.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface CustomerMapper {

    Customer toEntity(CustomerRequest customerRequest);
    CustomerResponse toResponse(Customer customer);
    List<CustomerResponse> toResponse(List<Customer> customerList);
    void update(@MappingTarget Customer entity, CustomerRequest request);


}
























/*
MapStruct kutuphanesi kullanildiginda mapper ile nesne donusumleri gerceklestirilir.
Bu metotlar, DTO(Data Transfer Object) ile Entity arasindaki donusumleri saglar.
MapStruck bu metotlarin gercek implementasyonlarini otomatik olarak olusturur.
*/






