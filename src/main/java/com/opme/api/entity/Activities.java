package com.opme.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="activities")
public class Activities {
	
	@Id
	@SequenceGenerator(name = "activities_id_seq", sequenceName = "activities_id_seq", allocationSize = 1)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "subtitle", nullable = false)
	private String subtitle;
	
	@Column(name = "servicelevelagreement", nullable = false)
	private Integer serviceLevelAgreement;

}
