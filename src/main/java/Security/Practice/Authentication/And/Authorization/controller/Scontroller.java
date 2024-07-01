package Security.Practice.Authentication.And.Authorization.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Security.Practice.Authentication.And.Authorization.entity.Studentss;
import Security.Practice.Authentication.And.Authorization.service.Simplement;

@RestController
@RequestMapping("/student/rest/api")
public class Scontroller {
	
	@Autowired
	private Simplement implement;
	
	@PostMapping("/post")
	public Studentss post(@RequestBody Studentss studentss) {
		return implement.post(studentss);
	}
	
	@GetMapping("/getall")
	public List<Studentss>getall(){
		return implement.getall();
	}
	

}
