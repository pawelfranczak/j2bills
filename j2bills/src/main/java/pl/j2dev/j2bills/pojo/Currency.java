package pl.j2dev.j2bills.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="currency")
public class Currency {

	private int id;
	private String iso4217;
	private boolean active;
	
	private Set<Journal> journal = new HashSet<Journal>(0);

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "iso4217")
	public String getIso4217() {
		return iso4217;
	}
	
	public void setIso4217(String iso4217) {
		this.iso4217 = iso4217;
	}
	
	@Column(name = "active")
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "currency")
	public Set<Journal> getJournal() {
		return journal;
	}
	
	public void setJournal(Set<Journal> journal) {
		this.journal = journal;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Currency [id=");
		builder.append(id);
		builder.append(", iso4217=");
		builder.append(iso4217);
		builder.append(", active=");
		builder.append(active);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
