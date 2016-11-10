package pl.j2dev.j2bills.pojo;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="currency")
public class Currency {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "iso4217")
	private String iso4217;
	
	@Column(name = "active")
	private boolean active;
	
	@OneToMany(mappedBy = "currency")
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
	public String getIso4217() {
		return iso4217;
	}
	public void setIso4217(String iso4217) {
		this.iso4217 = iso4217;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
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
