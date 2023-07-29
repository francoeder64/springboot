package sv.com.bancoagricola.pagosqr.example1.demo.model;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String name;
	private String email;
	private LocalDate birthday;
	@Transient
	private int age;
	
	public Client() {
		
	}
	
	public Client(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	
	public Client(String name, String email, LocalDate birthday) {
		this.name = name;
		this.email = email;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		return Period.between(birthday ,LocalDate.now() ).getYears();
	}



	@Override
	public String toString() {
		return this.name + " " + this.email;
	}
}
