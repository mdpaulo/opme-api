package com.opme.api.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.opme.api.enums.SlaStatusEnum;

@Entity
@Table(name="cards")
public class Cards {
	
	@Id
	@SequenceGenerator(name = "cards_id_seq", sequenceName = "cards_id_seq", allocationSize = 1)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "creationdate", nullable = false)
	private Timestamp creationDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "slastatus", nullable = false)
	private SlaStatusEnum slaStatus;
	
	@Column(name = "activitie_id", nullable = false)
	private Integer activitieId;
	
	@OneToOne
	@JoinColumn(name = "patient_id")
	private Patients patient;
	
	@OneToOne
	@JoinColumn(name = "healthinsurance_id")
	private HealthInsurance healthinsurance;
	
	@Column(name = "visit_id", nullable = false)
	private Integer visitId;
	
	@OneToOne
	@JoinColumn(name = "bill_id")
	private Bill bill;
	
	@Column(name ="totalamount", nullable =false)
	private BigDecimal totalAmount;
	
	@Column(name ="numberofpendencies", nullable =false)
	private Integer numberOfPendencies;
	
	@Column(name ="numberofopenpendencies", nullable =false)
	private Integer numberOfOpenPendencies;
	
	@Column(name ="numberofdocuments", nullable =false)
	private Integer numberOfDocuments;
	
	@Column(name ="numberofnotreceiveddocuments", nullable =false)
	private Integer numberOfNotReceivedDocuments;
	
	@Column(name ="numberofchecklistitem", nullable =false)
	private Integer numberOfCheckListItem;
	
	@Column(name ="numberofdonechecklistitem", nullable =false)
	private Integer numberOfDoneCheckListItem;
	
	public Cards() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public SlaStatusEnum getSlaStatus() {
		return slaStatus;
	}

	public void setSlaStatus(SlaStatusEnum slaStatus) {
		this.slaStatus = slaStatus;
	}

	public Integer getActivitieId() {
		return activitieId;
	}

	public void setActivitieId(Integer activitieId) {
		this.activitieId = activitieId;
	}

	public Patients getPatient() {
		return patient;
	}

	public void setPatient(Patients patient) {
		this.patient = patient;
	}

	public HealthInsurance getHealthinsurance() {
		return healthinsurance;
	}

	public void setHealthinsurance(HealthInsurance healthinsurance) {
		this.healthinsurance = healthinsurance;
	}

	public Integer getVisitId() {
		return visitId;
	}

	public void setVisitId(Integer visitId) {
		this.visitId = visitId;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getNumberOfPendencies() {
		return numberOfPendencies;
	}

	public void setNumberOfPendencies(Integer numberOfPendencies) {
		this.numberOfPendencies = numberOfPendencies;
	}

	public Integer getNumberOfOpenPendencies() {
		return numberOfOpenPendencies;
	}

	public void setNumberOfOpenPendencies(Integer numberOfOpenPendencies) {
		this.numberOfOpenPendencies = numberOfOpenPendencies;
	}

	public Integer getNumberOfDocuments() {
		return numberOfDocuments;
	}

	public void setNumberOfDocuments(Integer numberOfDocuments) {
		this.numberOfDocuments = numberOfDocuments;
	}

	public Integer getNumberOfNotReceivedDocuments() {
		return numberOfNotReceivedDocuments;
	}

	public void setNumberOfNotReceivedDocuments(Integer numberOfNotReceivedDocuments) {
		this.numberOfNotReceivedDocuments = numberOfNotReceivedDocuments;
	}

	public Integer getNumberOfCheckListItem() {
		return numberOfCheckListItem;
	}

	public void setNumberOfCheckListItem(Integer numberOfCheckListItem) {
		this.numberOfCheckListItem = numberOfCheckListItem;
	}

	public Integer getNumberOfDoneCheckListItem() {
		return numberOfDoneCheckListItem;
	}

	public void setNumberOfDoneCheckListItem(Integer numberOfDoneCheckListItem) {
		this.numberOfDoneCheckListItem = numberOfDoneCheckListItem;
	}
}
