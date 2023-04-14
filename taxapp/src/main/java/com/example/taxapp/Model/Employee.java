package com.example.taxapp.Model;
import java.time.LocalDate; // import the LocalDate class
import java.util.List;
import java.util.Set;

import com.example.taxapp.Model.Mobile;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee 
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "Employee Id")
    private int id;
    
    @Column(name = "FirstName")
    private String firstName;
    
    @Column(name = "lastName")
    private String lastName;
    
    @Column(name = "Email")
    private String email;
	 
	  @Column(name="DOJ")
	  private LocalDate DOJ;
	  
	 
	  @OneToMany(mappedBy = "mobile", fetch = FetchType.LAZY,
	          cascade = CascadeType.ALL)
	  private Set<Mobile> PhoneNumbers;
	  
	  @Column(name="salary")
	  private Long salary;
	  
    public Employee() {
    }

    public Employee(String firstName, String lastName, String email, LocalDate DOJ,Long salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.DOJ = DOJ;
        this.salary =salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDOJ() {
		return DOJ;
	}

	public void setDOJ(LocalDate dOJ) {
		DOJ = dOJ;
	}

	public Set<Mobile> getPhoneNumbers() {
		return PhoneNumbers;
	}

	public void setPhoneNumbers(Set<Mobile> phoneNumbers) {
		PhoneNumbers = phoneNumbers;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	@Override
    public String toString() {
        return "Employee{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + '}';
    }
    
}