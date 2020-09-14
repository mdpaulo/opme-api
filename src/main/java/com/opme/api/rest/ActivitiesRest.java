package com.opme.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
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
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseEntity<?> add(@RequestBody String json){
		try {
			actService.addActivitie(json);
			return new ResponseEntity<> (HttpStatus.OK);
		}catch(IllegalArgumentException paramsError) {
			return new ResponseEntity<> ("Invalid Params on request body: " + paramsError.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}catch(JsonParseException parseError) {
			return new ResponseEntity<> ("Invalid json format: "+ parseError.getMessage(),HttpStatus.UNSUPPORTED_MEDIA_TYPE);
		}catch (Exception error) {
			return new ResponseEntity<> ("Error on processing request: " + error.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
