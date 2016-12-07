package pl.j2dev.j2bills.pojo;

public class Currency {

	private int id;
	private String iso4217;
	private boolean active;
	
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
	
}
