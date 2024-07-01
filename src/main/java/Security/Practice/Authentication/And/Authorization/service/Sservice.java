package Security.Practice.Authentication.And.Authorization.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import Security.Practice.Authentication.And.Authorization.entity.Studentss;
import Security.Practice.Authentication.And.Authorization.repository.StudentRepository;

@Service
public class Sservice implements Simplement {
	
	@Autowired
	private StudentRepository repository;

	@Override
	public Studentss post(Studentss studentss) {
		return repository.save(studentss);
	}

	@Override
	public List<Studentss> getall() {
		return repository.findAll();
	}



}
