package demo.clininc.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MEDICINES")
public class Medicine {
	
	@Id
	@Column(name="MED_ID")
	private int medId;
	
	@Column(name="MED_NAME")
	private String medName;
	
	public Medicine(int id, String name){
		this.medId=id;
		this.medName=name;
	}

	public int getMedId() {
		return medId;
	}

	public void setMedId(int medId) {
		this.medId = medId;
	}

	public String getMedName() {
		return medName;
	}

	public void setMedName(String medName) {
		this.medName = medName;
	}


}
