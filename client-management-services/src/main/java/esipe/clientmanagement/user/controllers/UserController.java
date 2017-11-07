package esipe.clientmanagement.user.controllers;

// import org.springframework.data.domain.PageRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import esipe.restutils.RestManagement;
import esipe.models.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author Gokan EKINCI
 */
@RestController
@RequestMapping(path = "/users")
public class UserController {

	private String PATH_ROOT = "users/";

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity getUser(@PathVariable Long id) throws IOException {

		try {
			return RestManagement.getResponse(PATH_ROOT, id);
		} catch (Exception e) {
			ObjectMapper objectMapper = new ObjectMapper();
			ErrorModel errorModel = objectMapper.readValue(e.getMessage(),ErrorModel.class);
			return new ResponseEntity(errorModel,HttpStatus.FORBIDDEN);
		}

	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity getAllUser() throws IOException {

		try {
			return RestManagement.getResponse(PATH_ROOT, null);
		} catch (Exception e) {
			ObjectMapper objectMapper = new ObjectMapper();
			ErrorModel errorModel = objectMapper.readValue(e.getMessage(),ErrorModel.class);
			return new ResponseEntity(errorModel,HttpStatus.FORBIDDEN);
		}

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity createUser(@RequestBody UserDto user) throws IOException {

		try {
			return RestManagement.postReponse(PATH_ROOT, user);
		} catch (Exception e) {
			ObjectMapper objectMapper = new ObjectMapper();
			ErrorModel errorModel = objectMapper.readValue(e.getMessage(),ErrorModel.class);
			return new ResponseEntity(errorModel,HttpStatus.FORBIDDEN);
		}

	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity updateUser(@PathVariable Long id, @RequestBody UserDto user) throws IOException {

		try {
			RestManagement.putResponse(PATH_ROOT, id, user);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			ObjectMapper objectMapper = new ObjectMapper();
			ErrorModel errorModel = objectMapper.readValue(e.getMessage(),ErrorModel.class);
			return new ResponseEntity(errorModel,HttpStatus.FORBIDDEN);
		}

	}

}
