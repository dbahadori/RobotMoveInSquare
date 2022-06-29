package agent.example.agentworld.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler{

	 @ExceptionHandler(AgentNotFoundException.class)
	    public ResponseEntity<ErrorResponse> handleAgentNotFoundExceptions(
	        Exception e
	    ) {
	        HttpStatus status = HttpStatus.NOT_FOUND; // 404

	    // converting the stack trace to String
	    StringWriter stringWriter = new StringWriter();
	    PrintWriter printWriter = new PrintWriter(stringWriter);
	    e.printStackTrace(printWriter);
	    String stackTrace = stringWriter.toString();

	        return new ResponseEntity(new ErrorResponse(status,e.getMessage(),stackTrace), status);
	    }
	 
	 @ExceptionHandler(OutOfSquareException.class)
	    public ResponseEntity<ErrorResponse> handleOutOfSquareExceptions(
	        Exception e
	    ) {
	        HttpStatus status = HttpStatus.BAD_REQUEST; // 400
	        return new ResponseEntity(new ErrorResponse(status,e.getMessage()), status);
	    }
	 
	 @ExceptionHandler(BadActionException.class)
	    public ResponseEntity<ErrorResponse> handleBadActionExceptions(
	        Exception e
	    ) {
	        HttpStatus status = HttpStatus.BAD_REQUEST; // 400
	        return new ResponseEntity(new ErrorResponse(status,e.getMessage()), status);
	    }
	 
	 @ExceptionHandler(AgentConflictException.class)
	    public ResponseEntity<ErrorResponse> handleAgentConflictExceptions(
	        Exception e
	    ) {
	        HttpStatus status = HttpStatus.BAD_REQUEST; // 400
	        return new ResponseEntity(new ErrorResponse(status,e.getMessage()), status);
	    }
}
