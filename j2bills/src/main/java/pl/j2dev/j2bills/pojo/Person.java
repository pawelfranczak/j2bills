package pl.j2dev.j2bills.pojo;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue
	int id;
	
	@Column(name = "firstname")
	String firstName;
	
	@Column(name = "lastname")
	String lastName;
	
	@ManyToOne
	Users users;
	
	@OneToMany(mappedBy = "person")
	private Collection<Journal> journals;
	
	public void setJournals(Collection<Journal> journals) {
		this.journals = journals;
	}
	
	public Collection<Journal> getJournals() {
		return journals;
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

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	
	
}
