package Security.Practice.Authentication.And.Authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Security.Practice.Authentication.And.Authorization.entity.Studentss;

@Repository
public interface StudentRepository extends JpaRepository<Studentss, Integer> {

}
