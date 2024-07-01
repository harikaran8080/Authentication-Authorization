package Security.Practice.Authentication.And.Authorization.common;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler
	public ResponseEntity<APIresponse>ExceptionHandler(Exception e){
		APIresponse apIresponse=new APIresponse();
		apIresponse.setError("Oops Something Went Wrong");
		apIresponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return ResponseEntity
				.status(apIresponse.getStatus())
				.body(apIresponse);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<APIresponse>HandlerAccessException(AccessdeniedException e){
		APIresponse apIresponse=new APIresponse();
		apIresponse.setError("Unauthorized");
		apIresponse.setStatus(HttpStatus.UNAUTHORIZED.value());
		return ResponseEntity
				.status(apIresponse.getStatus())
				.body(apIresponse);
	}
	

	
	

}
