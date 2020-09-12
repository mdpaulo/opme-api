package com.opme.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.opme.api.service.ActivitiesService;

@RestController
@RequestMapping("/activities")
public class ActivitiesRest {

	@Autowired
	private ActivitiesService actService;
	
	@RequestMapping(value = "/getall", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ResponseEntity<?> getAll(){
		ResponseEntity<?> response = null;
		JsonObject jsonresponse = null;
		try {
			jsonresponse = actService.getAllActivities();
			response = new ResponseEntity<>(jsonresponse.toString(),jsonresponse != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		} catch (Exception error) {
			response = new ResponseEntity<> ("Error on processing request: " + error.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
}
