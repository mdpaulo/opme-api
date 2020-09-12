package com.opme.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.opme.api.enums.BillTypeEnum;

@Entity
@Table(name="bill")
public class Bill {
	
	@Id
	@SequenceGenerator(name = "bill_id_seq", sequenceName = "bill_id_seq", allocationSize = 1)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private BillTypeEnum type;

	public Bill() {}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BillTypeEnum getType() {
		return type;
	}

	public void setType(BillTypeEnum type) {
		this.type = type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bill [id=");
		builder.append(id);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}
}
