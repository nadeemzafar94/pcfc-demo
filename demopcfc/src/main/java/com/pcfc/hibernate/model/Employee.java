package com.pcfc.hibernate.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "First name is required")
    @Size(min = 1, message = "First name is required")
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull(message = "Last name is required")
    @Size(min = 1, message = "Last name is required")
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "department")
	@NotNull(message = "Department is required")
    @Size(min = 2, message = "Deaprtment is required")
	private String department;
	
	@NotNull(message = "Salary is required")
	@Range(min=0, message=" Salary is required")
	private Double salary=0D;
	
	@NotNull(message = "Date of birth is required")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="managerid")
    private Employee manager;
	
	@Transient
    private String managerid;

    @OneToMany(mappedBy="manager")
    private Set<Employee> team = new HashSet<Employee>();
	
	@CreationTimestamp
	private Date createdts;

	public Employee() {
		
	}
	
	public Employee(String firstName, String lastName, String department, Double salary,Date dob, Employee manager) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.salary = salary;
		this.manager = manager;
		this.dob = dob;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Set<Employee> getTeam() {
		return team;
	}

	public void setTeam(Set<Employee> team) {
		this.team = team;
	}

	public Date getCreatedts() {
		return createdts;
	}

	public void setCreatedts(Date createdts) {
		this.createdts = createdts;
	}

	public String getManagerid() {
		return managerid;
	}

	public void setManagerid(String managerid) {
		this.managerid = managerid;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", department="
				+ department + ", salary=" + salary + ", dob=" + dob + ", manager=" + manager + ", createdts="
				+ createdts + "]";
	}
	
	
	
}
