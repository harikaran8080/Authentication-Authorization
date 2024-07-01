package Security.Practice.Authentication.And.Authorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import Security.Practice.Authentication.And.Authorization.common.APIresponse;
import Security.Practice.Authentication.And.Authorization.dto.LoginDto;
import Security.Practice.Authentication.And.Authorization.dto.SignUpDto;
import Security.Practice.Authentication.And.Authorization.service.WorkerImplement;

@Controller
public class StudentController {

	@Autowired
	private WorkerImplement implement;

	@PostMapping("/signup")
	public ResponseEntity<APIresponse> signup(@RequestBody SignUpDto dto) {
		APIresponse apIresponse = implement.signup(dto);
		return ResponseEntity.status(apIresponse.getStatus()).body(apIresponse);
	}

	@PostMapping("/login")
	public ResponseEntity<APIresponse> login(@RequestBody LoginDto dto) {
		APIresponse apIresponse = implement.login(dto);
		return ResponseEntity.status(apIresponse.getStatus()).body(apIresponse);
		}

	@GetMapping("/private/api")
	public ResponseEntity<APIresponse> privateapi(@RequestHeader(value = "authorization") String authorization)
			throws Exception {
		APIresponse apiResponse = implement.privateapi(authorization);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	
}
