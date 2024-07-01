package Security.Practice.Authentication.And.Authorization.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import Security.Practice.Authentication.And.Authorization.common.APIresponse;
import Security.Practice.Authentication.And.Authorization.common.JWToken;
import Security.Practice.Authentication.And.Authorization.dto.LoginDto;
import Security.Practice.Authentication.And.Authorization.dto.SignUpDto;
import Security.Practice.Authentication.And.Authorization.entity.Students;
import Security.Practice.Authentication.And.Authorization.entity.Studentss;
import Security.Practice.Authentication.And.Authorization.repository.StudentRepository;
import Security.Practice.Authentication.And.Authorization.repository.WorkerRepository;
import io.jsonwebtoken.Jwts;

@Service
public class StudentService implements WorkerImplement{
	
	@Autowired
	private WorkerRepository repository;
	@Autowired
	private JWToken jwToken;
	@Autowired
	private StudentRepository repository2;
	
	
	@Override
	public APIresponse signup(SignUpDto dto) {
		APIresponse apIresponse=new APIresponse();
		Students students=new Students();
		students.setStudentName(dto.getStudentName());
		students.setStudentAge(dto.getGender());
		students.setRollNumber(dto.getRollNumber());
		students.setGender(dto.getGender());
		students.setDepartment(dto.getDepartment());
		
		if((students.getRollNumber() == null) || (students.getRollNumber().isEmpty())) {
			apIresponse.setStatus(HttpStatus.BAD_REQUEST.value());
			apIresponse.setError("No Data ");
		}
		else {
			apIresponse.setStatus(HttpStatus.OK.value());
			apIresponse.setData(students);
			repository.save(students);
			String token= jwToken.GenerateJWT(students);
			Map<String, Object> data= new HashMap<String, Object>();
			data.put("Access Token", token);
			apIresponse.setData(data);
			
		}
		return apIresponse;
	}


	@Override
	public APIresponse login(LoginDto dto) {
		APIresponse apIresponse=new APIresponse();
		Students students=repository.findByNameRollNumber(dto.getStudentName(),dto.getRollNumber());
		if(students==null) {
			apIresponse.setStatus(HttpStatus.BAD_REQUEST.value());
			apIresponse.setError("login failed");
			apIresponse.setData("incorrect");
		}
		else {
			apIresponse.setStatus(HttpStatus.OK.value());
			apIresponse.setData(students);
			String token = jwToken.GenerateJWT(students);
			Map<String ,Object>data=new HashMap<String, Object>();
			data.put("Access Token", token);
			apIresponse.setData(data);
		}
		return apIresponse;
	}


	@Override
	public APIresponse privateapi(String authorization) throws Exception {
		APIresponse apIresponse=new APIresponse();
		jwToken.verify(authorization);
		apIresponse.setStatus(HttpStatus.OK.value());
		apIresponse.setData("This is Private Api");
		return apIresponse;
	}

/////////////////////////Other API \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\



}
