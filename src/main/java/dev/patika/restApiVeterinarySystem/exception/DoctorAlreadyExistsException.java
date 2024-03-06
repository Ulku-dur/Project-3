package dev.patika.restApiVeterinarySystem.exception;

public class DoctorAlreadyExistsException extends RuntimeException{
    public DoctorAlreadyExistsException(String mail) {
        super("The doctor with the mail " + mail +" has been already registered in the system!");
    }
}
