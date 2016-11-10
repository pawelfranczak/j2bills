package pl.j2dev.j2bills.pojo;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue
	int id;
	
	@ManyToOne
	Users users;
	
	@Column(name = "accountname")
	String accountName;
	
	@Column(name = "description")
	String description;
	
	@Column(name = "balance")
	BigDecimal balance;
	
	@OneToMany(mappedBy = "account")
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

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	
	
}
