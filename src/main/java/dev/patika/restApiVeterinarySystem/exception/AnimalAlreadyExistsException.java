package dev.patika.restApiVeterinarySystem.exception;

import dev.patika.restApiVeterinarySystem.dto.request.AnimalRequest;

public class AnimalAlreadyExistsException extends RuntimeException {
    public AnimalAlreadyExistsException(Long id) {
        super("This animal with the id " + id + " has already been registered in the system !");
    }
    public AnimalAlreadyExistsException(Long id, AnimalRequest request) {
        super();
    }
}
