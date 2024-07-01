package Security.Practice.Authentication.And.Authorization.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Students {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
	
	@Column(name = "studentname")
	private String studentName;
	
	@Column(name = "studentAge")
	private String studentAge;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name ="rollnumber")
	private String rollNumber;
	
	@Column(name = "department")
	private String department;

}
