package pl.j2dev.j2bills.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	String username;
	String password;
	boolean enabled;

	private Set<Account> account = new HashSet<Account>(0);	
	private Set<Person> person = new HashSet<Person>(0);	
	
	private Set<Journal> journal = new HashSet<Journal>(0);	
	

	@Id
	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "enabled")	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Account> getAccount() {
		return account;
	}

	public void setAccount(Set<Account> account) {
		this.account = account;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Person> getPerson() {
		return person;
	}
	
	public void setPerson(Set<Person> person) {
		this.person = person;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Journal> getJournal() {
		return journal;
	}
	
	public void setJournal(Set<Journal> journal) {
		this.journal = journal;
	}

	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Users [username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", enabled=");
		builder.append(enabled);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
