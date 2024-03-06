package dev.patika.restApiVeterinarySystem.repository;

import dev.patika.restApiVeterinarySystem.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByMail (String mail);
}
