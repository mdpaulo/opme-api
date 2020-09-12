package com.opme.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="healthinsurance")
public class HealthInsurance {
	
	@Id
	@SequenceGenerator(name = "healthinsurance_id_seq", sequenceName = "healthinsurance_id_seq", allocationSize = 1)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	public HealthInsurance() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HealthInsurance [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
}
