package dev.patika.restApiVeterinarySystem.exception;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.time.LocalDateTime;
@Slf4j
//@Slf4j hata mesajını konsolda görmemizi sağlayan anatasyondur
public class GlobalExceptionHandler {
// swaaggerda istek atılınca swagger responsebody de özelleştirilmiş hata mesajlarını görebilmek için
// oluşturulan metotlar

    @ExceptionHandler(IdNotFoundException.class)
    ResponseEntity<ErrorResponse> handleIdNotFoundException (WebRequest request,
                                                             IdNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatuscode(404);
        errorResponse.setOccurenceDate(LocalDateTime.now());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDescription(request.getDescription(false));
        log.error(errorResponse.toString());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DoctorAlreadyExistsException.class)
    ResponseEntity<ErrorResponse> handleDoctorAlreadyExistsException (WebRequest request,
                                                                      DoctorAlreadyExistsException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatuscode(400);
        errorResponse.setOccurenceDate(LocalDateTime.now());
        errorResponse.setMessage(ex.getMessage());
        // hatanın hangi url den geldiğini görmek için yazdık
        errorResponse.setDescription(request.getDescription(false));
        // error mesajını konsola print et
        log.error(errorResponse.toString());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }


}
