package dev.patika.restApiVeterinarySystem.exception;

import dev.patika.restApiVeterinarySystem.dto.request.*;

public class IdNotFoundException extends RuntimeException{
public IdNotFoundException (Long id) {
    super("There was no object with id = " +id+ " item in the system !");
}
public IdNotFoundException(Long id, AnimalRequest request) { super("The animal with the ID " + id + " that you are trying to update could not be found in the system!");}
public IdNotFoundException(Long id, AppointmentRequest request) {super("The appointment with ID " + id + " could not be located for the update!");}
public IdNotFoundException(AvailableDateRequest request) {super("The date is not available!");}
public IdNotFoundException (Long id, CustomerRequest request) { super("The pet owner with the ID " + id + " that you are trying to update could not be found in the system!");}
public IdNotFoundException(Long id, DoctorRequest request) {super("The system couldn't locate the doctor with the ID " + id + " that you're attempting to update!");}
public IdNotFoundException(Long id, VaccineRequest request) { super("The vaccine with ID " + id + " could not be found in the system for the update!");}

}
