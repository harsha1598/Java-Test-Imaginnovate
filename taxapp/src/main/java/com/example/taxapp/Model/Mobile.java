package com.example.taxapp.Model;
import org.hibernate.annotations.NaturalId;
import javax.persistence.*;

@Entity
@Table(name = "Mobile")
public class Mobile {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
	
	@Enumerated(EnumType.ORDINAL)
    private Long Emp_Id;
	
	@Enumerated(EnumType.ORDINAL)
    private Long MobileNumber;

	public Mobile(Long id, Long emp_Id, Long mobileNumber) {
		super();
		Id = id;
		Emp_Id = emp_Id;
		MobileNumber = mobileNumber;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getEmp_Id() {
		return Emp_Id;
	}

	public void setEmp_Id(Long emp_Id) {
		Emp_Id = emp_Id;
	}

	public Long getMobileNumber() {
		return MobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		MobileNumber = mobileNumber;
	}
    

}
