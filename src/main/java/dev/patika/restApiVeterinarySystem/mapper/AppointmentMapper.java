package dev.patika.restApiVeterinarySystem.mapper;

import dev.patika.restApiVeterinarySystem.dto.request.AppointmentRequest;
import dev.patika.restApiVeterinarySystem.dto.response.AppointmentResponse;
import dev.patika.restApiVeterinarySystem.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface AppointmentMapper {
    Appointment asEntity(AppointmentRequest appointmentRequest);
    AppointmentResponse toResponse(Appointment appointment);
    List<AppointmentResponse> toResponse(List<Appointment> appointmentList);
    void update(@MappingTarget Appointment entity, AppointmentRequest appointmentRequest);


}
