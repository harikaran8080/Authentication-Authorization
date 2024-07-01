package Security.Practice.Authentication.And.Authorization.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name ="studentss")
public class Studentss {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sId;
	
	private String studentNames;
	
	private String departMent;
	

}
