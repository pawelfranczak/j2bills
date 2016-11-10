package pl.j2dev.j2bills.pojo;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@Column(name = "username")
	String username;
	
	@Column(name = "password")
	String password;
	
	@Column(name = "enbled")
	boolean enabled;
	
	@OneToMany(mappedBy = "users")
	private Collection<Person> persons;

	@OneToMany(mappedBy = "users")
	private Collection<Account> accounts;
	
	@OneToMany(mappedBy = "users")
	private Collection<Journal> journals;
	
	public void setJournals(Collection<Journal> journals) {
		this.journals = journals;
	}
	
	public Collection<Journal> getJournals() {
		return journals;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public Collection<Person> getPersons() {
		return persons;
	}
	
	public void setPersons(Collection<Person> persons) {
		this.persons = persons;
	}
	
	public Collection<Account> getAccounts() {
		return accounts;
	}
	
	public void setAccounts(Collection<Account> accounts) {
		this.accounts = accounts;
	}
	
}
