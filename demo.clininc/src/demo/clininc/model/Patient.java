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
@Table(name = "PATIENTS")
public class Patient {

	@Id
	@Column(name = "PATIENT_ID")
	private int patientId;

	@Column(name = "PATIENT_NAME")
	private String name;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "REGISTERED_DATE")
	private Date date;

	public List<Prescription> getPrescription() {
		return prescription;
	}

	public void setPrescription(List<Prescription> prescription) {
		this.prescription = prescription;
	}

	@OneToMany(cascade = CascadeType.ALL)  
	@JoinColumn(name="patientId")  
	private List<Prescription> prescription;
	
	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Patient(int id, String name, String email, Date date) {
		this.patientId = id;
		this.name = name;
		this.email = email;
		this.date = date;
	}
}
