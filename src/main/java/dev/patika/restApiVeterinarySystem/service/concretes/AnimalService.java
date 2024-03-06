package dev.patika.restApiVeterinarySystem.service.concretes;
import dev.patika.restApiVeterinarySystem.dto.request.AnimalRequest;
import dev.patika.restApiVeterinarySystem.dto.response.AnimalResponse;
import dev.patika.restApiVeterinarySystem.entity.Animal;
import dev.patika.restApiVeterinarySystem.exception.AnimalAlreadyExistsException;
import dev.patika.restApiVeterinarySystem.exception.IdNotFoundException;
import dev.patika.restApiVeterinarySystem.mapper.AnimalMapper;
import dev.patika.restApiVeterinarySystem.repository.AnimalRepository;
import dev.patika.restApiVeterinarySystem.service.abstracts.IAnimalService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalService implements IAnimalService {
    private final AnimalRepository animalRepository;
    private final AnimalMapper animalMapper;

    public AnimalService(AnimalRepository animalRepository, AnimalMapper animalMapper) {
        this.animalRepository = animalRepository;
        this.animalMapper = animalMapper;
    }

    public List<AnimalResponse> findAll() {
        return animalMapper.toResponse(animalRepository.findAll());
    }
    public AnimalResponse getById(Long id) {
        return animalMapper.toResponse(animalRepository.findById(id).orElseThrow(() ->
             new RuntimeException("Animal with id " + id + " not found!")));
    }

    public AnimalResponse create (AnimalRequest request) {
        Optional<Animal> animalFromDb = animalRepository.findByNameAndSpeciesAndBreed(
                request.getName(), request.getSpecies(), request.getBreed());

        if(animalFromDb.isPresent()) {
            throw new AnimalAlreadyExistsException(animalFromDb.get().getId());
        }
        Animal animalSaved = animalRepository.save(animalMapper.toEntity(request));
        return animalMapper.toResponse(animalSaved);
    }

    public AnimalResponse update(Long id, AnimalRequest request) {
        Optional<Animal> animalFromDb = animalRepository.findById(id);
        Optional<Animal> isAnimalExist = animalRepository.findByCustomerIdAndNameAndSpeciesAndBreed(request.getCustomer().getId(), request.getName(), request.getSpecies(), request.getBreed());
        if (animalFromDb.isEmpty()) {
            throw new IdNotFoundException(id, request);
        }
        if (isAnimalExist.isPresent() && !isAnimalExist.get().getId().equals(id))  {
            throw new AnimalAlreadyExistsException(id);
        }
        Animal animal = animalFromDb.get();
        animalMapper.update(animal, request);
        return animalMapper.toResponse((animalRepository.save(animal)));
    }

    public void deleteById(Long id) {
        Optional<Animal> animalFromDb = animalRepository.findById(id);
        if(animalFromDb.isPresent()) {
            animalRepository.delete(animalFromDb.get());
        } else {
            throw new IdNotFoundException(id);
        }
    }

    public List<AnimalResponse> findByName(String name) {
        return animalMapper.toResponse(animalRepository.findByName(name));
    }

    public List<AnimalResponse> findByCustomerName(String customerName) {
        return animalMapper.toResponse(animalRepository.findByCustomerName(customerName));
    }

    public List<AnimalResponse> findByCustomerId(Long customerId) {
        return animalMapper.toResponse(animalRepository.findByCustomerId(customerId));
    }

}
