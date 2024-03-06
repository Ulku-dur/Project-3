package dev.patika.restApiVeterinarySystem.service.concretes;
import dev.patika.restApiVeterinarySystem.dto.request.AppointmentRequest;
import dev.patika.restApiVeterinarySystem.dto.response.AppointmentResponse;
import dev.patika.restApiVeterinarySystem.entity.Appointment;
import dev.patika.restApiVeterinarySystem.exception.AppointmentAlreadyExistsException;
import dev.patika.restApiVeterinarySystem.exception.IdNotFoundException;
import dev.patika.restApiVeterinarySystem.mapper.AppointmentMapper;
import dev.patika.restApiVeterinarySystem.repository.AppointmentRepository;
import dev.patika.restApiVeterinarySystem.service.abstracts.IAppointmentService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service

public class AppointmentService implements IAppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final AvailableDateService availableDateService;

    public AppointmentService(AppointmentRepository appointmentRepository, AppointmentMapper appointmentMapper, AvailableDateService availableDateService) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
        this.availableDateService = availableDateService;
    }

    public List<AppointmentResponse> findAll() {
        return appointmentMapper.toResponse((appointmentRepository.findAll()));
    }

    public AppointmentResponse getById(Long id) {
        return appointmentMapper.toResponse(appointmentRepository.findById(id).orElseThrow(() ->
                new RuntimeException("The appointment with ID " + id + " could not be found!")));
    }

    public AppointmentResponse create(AppointmentRequest request) {
        LocalDateTime dateTime = request.getAppointmentDate();
        Long doctorId = request.getDoctor().getId();

        //doktorun belirtilen gun ve saat icin uygun olup olmadiginin kontrolleri yapilir.
        if (availableDateService.isDoctorAvailable(doctorId,dateTime)) {
            throw new AppointmentAlreadyExistsException(request);
        }
        if (isAppointmentDateExistOnDate(doctorId,dateTime)) {
            throw new AppointmentAlreadyExistsException(doctorId, dateTime);
        } else {
            // create an appointment
            Appointment appointmentSaved = appointmentRepository.save(appointmentMapper.asEntity(request));
            return appointmentMapper.toResponse(appointmentSaved);
        }
    }

    //doktorun belirtilen tarihte ve saatte baska bir randevusu olup olmadigi kontrolu
    public boolean isAppointmentDateExistOnDate (Long doctorId, LocalDateTime appointmentDate) {
        return appointmentRepository.existsByDoctorIdAndAppointmentDate(doctorId,appointmentDate);
    }

    public AppointmentResponse update(Long id, AppointmentRequest request) {
        Optional<Appointment> appointmentFromDb = appointmentRepository.findById(id);
        Optional<Appointment> isAppointmentExist = appointmentRepository.findByAppointmentDate(request.getAppointmentDate());

        if (appointmentFromDb.isEmpty()) {
            throw new IdNotFoundException(id, request);
        }
        Appointment appointment = appointmentFromDb.get();
        appointmentMapper.update(appointment, request);
        return appointmentMapper.toResponse((appointmentRepository.save(appointment)));
    }

    public void deleteById(Long id) {
        Optional<Appointment> appointmentFromDb = appointmentRepository.findById(id);
        if (appointmentFromDb.isPresent()) {
            appointmentRepository.delete(appointmentFromDb.get());
        } else {
            throw new IdNotFoundException(id);
        }
    }

    public List<AppointmentResponse> findByAppointmentDateBetweenAndAnimalId(LocalDateTime startDate, LocalDateTime endDate, Long animalId) {
        return appointmentMapper.toResponse(appointmentRepository.findByAppointmentDateBetweenAndAnimalId(startDate,endDate, animalId));
    }

    public List<AppointmentResponse> findByAppointmentDateBetweenAndDoctorId(LocalDateTime startDate, LocalDateTime endDate, Long doctorId) {
        return appointmentMapper.toResponse(appointmentRepository.findByAppointmentDateBetweenAndDoctorId(startDate,endDate, doctorId));
    }
}






