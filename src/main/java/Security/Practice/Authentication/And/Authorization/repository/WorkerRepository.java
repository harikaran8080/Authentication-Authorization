package Security.Practice.Authentication.And.Authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Security.Practice.Authentication.And.Authorization.entity.Students;
import Security.Practice.Authentication.And.Authorization.entity.Studentss;

@Repository
public interface WorkerRepository extends JpaRepository<Students, Long>{

	@Query(value = "select * from Students where studentname like %:studentName% and rollnumber like %:rollNumber%",nativeQuery = true)
	Students findByNameRollNumber(String studentName, String rollNumber);

	

}
