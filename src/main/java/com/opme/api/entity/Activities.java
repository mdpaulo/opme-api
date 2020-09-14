package com.opme.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.google.gson.JsonObject;

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
	
	public Activities() {}
	
	public Activities(JsonObject jsonData) {
		if(jsonData.get("activityTitle").getAsString() == null || jsonData.get("activityTitle").getAsString().trim().isEmpty()) {
			throw new IllegalArgumentException("Invalid Value for field activityTitle");
		}
		if(jsonData.get("activitySubtitle").getAsString() == null || jsonData.get("activitySubtitle").getAsString().trim().isEmpty()) {
			throw new IllegalArgumentException("Invalid Value for field activityTitle");
		}
		if(jsonData.get("sla").getAsString() == null || jsonData.get("sla").getAsString().trim().isEmpty()) {
			throw new IllegalArgumentException("Invalid Value for field activityTitle");
		}
		this.title = jsonData.get("activityTitle").getAsString();
		this.subtitle = jsonData.get("activitySubtitle").getAsString();
		this.serviceLevelAgreement = jsonData.get("sla").getAsInt();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Activities [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", subtitle=");
		builder.append(subtitle);
		builder.append(", serviceLevelAgreement=");
		builder.append(serviceLevelAgreement);
		builder.append("]");
		return builder.toString();
	}
	
	public JsonObject toJson() {
		JsonObject object = new JsonObject();
		object.addProperty("activityId", id);
		object.addProperty("activityTitle", title);
		object.addProperty("activitySubtitle", subtitle);
		object.addProperty("sla", serviceLevelAgreement);
		return object;
	}

}
