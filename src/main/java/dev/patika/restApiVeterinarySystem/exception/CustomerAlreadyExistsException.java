package dev.patika.restApiVeterinarySystem.exception;

public class CustomerAlreadyExistsException extends RuntimeException{
    public CustomerAlreadyExistsException(Long id) {
        super("The pet owner with the ID " + id + " has already been registered in the system!");
    }
}
