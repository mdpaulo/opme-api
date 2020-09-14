package com.opme.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.opme.api.entity.Activities;
import com.opme.api.repository.ActivitiesRepository;

@Service("activitiesService")
public class ActivitiesService {
	
	@Autowired
	private ActivitiesRepository actRepo;
	
	public JsonObject getAllActivities() {
		List<Activities> activitiesList = new ArrayList<Activities>();
		JsonArray jsonList = new JsonArray();
		JsonObject result = new JsonObject();
		
		actRepo.findAll().forEach(activitiesList::add);
		if(!activitiesList.isEmpty()) {
			for(Activities registry : activitiesList) {
				jsonList.add(registry.toJson());
			}
			result.add("activities", jsonList);
		}else {
			result = null;
		}
		return result;
	}
	
	public void addActivitie(String jsonActivitieData) throws IllegalArgumentException, JsonParseException, Exception {
		actRepo.save(new Activities(new JsonParser().parse(jsonActivitieData).getAsJsonObject()));
	}
}
