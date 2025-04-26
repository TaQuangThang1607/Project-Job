package vn.hoidanit.jobhunter.util.error;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collector;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletResponse;
import vn.hoidanit.jobhunter.domain.RestResponse;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = {
            // IdInvalidException.class,
            UsernameNotFoundException.class,
            BadCredentialsException.class
    })

    // can thiet vao phan handle
    public ResponseEntity<RestResponse<Object>> handleIdException(Exception ex) {
        RestResponse<Object> res = new RestResponse<Object>();
        res.setStatus(HttpStatus.BAD_REQUEST.value());
        res.setError(ex.getMessage());
        res.setMessage("Exception orrcus...");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }

    // public ResponseEntity<Response<Object>>
    // validationError(MethodArgumentNotValidException ex){
    // BindingResult result = ex.getBindingResult();
    // final List<FieldError> fileErrors = result.getFieldErrors();

    // RestResponse<Object> res = new RestResponse<>();
    // res.setStatus(HttpStatus.BAD_REQUEST.value());
    // res.setError(ex.getBody().getDetail());

    // List<String> errors = fileErrors.stream().map(f ->
    // f.getRejectedValue()).collect(Collectors.t)
    // }
}
