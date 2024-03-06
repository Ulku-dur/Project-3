# Veterinary Management System

The Veterinary Management System is a REST API project developed to manage basic records related to veterinary practice 
such as animal owners, animals, doctors, doctors' available days, appointments, and vaccinations. This application will 
be used by veterinary staff.


## The technologies used :

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Lombok
- Mapstruck
- Postman
- Swagger

## The project structure

The project contains the following components:

- **ENTITY**
- **REPOSITORY**
- **DTO** / REQUEST-RESPONSE
- **MAPPER**
- **SERVICE**
- **CONTROLLER**
- **EXCEPTION**

![UML Diyagramı](src%2Fmain%2Fjava%2Fimages%2Fuml-diagram.png)

## Starting the application

Since the project is developed with Spring Boot, you can follow the steps below to start the application:

1. Download the project source code to your computer.
2. Create your PostgreSQL database and update the connection information in the application.properties file.
3. Open the project in an IDE (IntelliJ IDEA, Eclipse, etc.).
4. Find the `restApiVeterinarySystemApplication` class and run it.

When the application is started, you can access the API at http://localhost:8080.


## Endpoints

Here is a list of basic endpoints provided by the API:

| Endpoint                                     | HTTP methods| Description                                                          |
|----------------------------------------------|:------------|----------------------------------------------------------------------|
| **vaccines**                                 |             |                                                                      |
| `/api/v1/vaccines/{id}`                      | GET         | Retrieve the vaccination with the specified ID.                      |
| `/api/v1/vaccines/{id}`                      | PUT         | Update the vaccination with the specified ID.                        |
| `/api/v1/vaccines/{id}`                      | DELETE      | Delete the vaccination with the specified ID.                        |
| `/api/v1/vaccines`                           | GET         | Retrieve all vaccinations.                                           |
| `/api/v1/vaccines`                           | POST        | Add a vaccination.                                                   |
| `/api/v1/vaccines/finishDate`                | GET         | Retrieve vaccination records based on the entered date range.        |
| `/api/v1/vaccines/findByAnimalId/{animalId}` | GET         | Retrieve all vaccination records for a specific animal.              |
|                                              |             |                                                                      |
| **doctors**                                  |             |                                                                      |
| `/api/v1/doctors/{id}`                       | GET         | Retrieve the doctor with the specified ID.                           |
| `/api/v1/doctors/{id}`                       | PUT         | Update the doctor with the specified ID.                             |
| `/api/v1/doctors/{id}`                       | DELETE      | Delete the doctor with the specified ID.                             |
| `/api/v1/doctors`                            | GET         | Retrieve all vaccinations.                                           |
| `/api/v1/doctors`                            | POST        | Add a doctor.                                                        |
|                                              |             |                                                                      |
| **customers**                                |             |                                                                      |
| `/api/v1/customers/{id}`                     | GET         | Retrieve the animal owner with the specified ID.                     |
| `/api/v1/customers/{id}`                     | PUT         | Update the animal owner with the specified ID.                       |
| `/api/v1/customers/{id}`                     | DELETE      | Delete the animal owner with the specified ID.                       |
| `/api/v1/customers`                          | GET         | Fetch all animal owner.                                              |
| `/api/v1/customers`                          | POST        | Add a doctor.                                                        |
| `/api/v1/customers/byName`                   | GET         | Retrieve animal owners by name.                                      |
|                                              |             |                                                                      |
| **available_dates**                          |             |                                                                      |
| `/api/v1/available_dates/{id}`               | GET         | Retrieve the available day with the specified ID.                    |
| `/api/v1/available_dates/{id}`               | PUT         | Update the available day with the specified ID.                      |
| `/api/v1/available_dates/{id}`               | DELETE      | Delete the available day with the specified ID.                      |
| `/api/v1/available_dates`                    | GET         | Retrieve all available days.                                         |
| `/api/v1/available_dates`                    | POST        | Add an available day.                                                |
|                                              |             |                                                                      |
| **appointments**                             |             |                                                                      |
| `/api/v1/appointments/{id}`                  | GET         | Retrieve the appointment with the specified ID.                      |
| `/api/v1/appointments/{id}`                  | PUT         | Update the appointment with the specified ID.                        |
| `/api/v1/appointments/{id}`                  | DELETE      | Delete the appointment with the specified ID.                        |
| `/api/v1/appointments`                       | GET         | Fetch all appointments.                                              |
| `/api/v1/appointments`                       | POST        | Add an appointment                                                   |
| `/api/v1/appointments/doctorId`              | GET         | Appointments based on the date range and doctor entered by the user. |
| `/api/v1/appointments/animalId`              | GET         | Appointments based on the date range and animal entered by the user. |
|                                              |             |                                                                      |
| **animals**                                  |             |                                                                      |
| `/api/v1/animals/{id}`                       | GET         | Retrieve the animal with the specified ID.                           |
| `/api/v1/animals/{id}`                       | PUT         | Update the animal with the specified ID.                             |
| `/api/v1/animals/{id}`                       | DELETE      | Delete the animal with the specified ID.                             |
| `/api/v1/animals`                            | GET         | Retrieve all animals                                                 |
| `/api/v1/animals`                            | POST        | Add an animal.                                                       |
| `/api/v1/animals/byName`                     | GET         | Filter animals by name.                                              |
| `/api/v1/animals/byCustomerName`             | GET         | Filter animals by animal owners name.                                |
|                                              |             |                                                                      |

You can review the respective controller classes for details of each endpoint.

The following video demonstrates how the project works and the basic steps for usage.
[Watch the Video](https://www.loom.com/share/c40324598a104cc4b622025b01821f1b?sid=db1ef8a3-7241-455e-a113-9ab0371bfb76)





