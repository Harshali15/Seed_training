package demo.clininc.model;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PRESCRIPTIONS")
public class Prescription {

	@Id
	@Column(name="PRES_ID")
	private int presId;
	
	@Column(name="PRES_DATE")
	private Date presDate;
	
	
	@Column(name="PATIENT_ID")
	private int patientId;
	
	@Column(name="MEDICINE_NAME")
	private String medName;
	
	@OneToMany(cascade = CascadeType.ALL)  
	@JoinColumn(name="medId")  
	private List<Medicine> meds;
	
    public Prescription(int presId,Date presDate,int pId, String medName){
    	this.presId=presId;
    	this.presDate=presDate;
    	this.patientId=pId;
    	this.medName=medName;
    	
    }

	public int getPresId() {
		return presId;
	}

	public void setPresId(int presId) {
		this.presId = presId;
	}

	public Date getPresDate() {
		return presDate;
	}

	public void setPresDate(Date presDate) {
		this.presDate = presDate;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getMedName() {
		return medName;
	}

	public void setMedName(String medName) {
		this.medName = medName;
	}

}
