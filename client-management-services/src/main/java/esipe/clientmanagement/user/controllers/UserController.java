package esipe.clientmanagement.user.controllers;

import esipe.restutils.RestManagement;
import esipe.models.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author Gokan EKINCI
 */
@RestController
@RequestMapping(path = "/users")
public class UserController {

	private String PATH_ROOT = "users/";

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity getUser(@PathVariable Long id) throws IOException {
		return RestManagement.getResponse(PATH_ROOT, id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity getAllUser() throws IOException {
		return RestManagement.getResponse(PATH_ROOT, null);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity createUser(@RequestBody UserDto user) throws IOException {
		return RestManagement.postReponse(PATH_ROOT, user);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity updateUser(@PathVariable Long id, @RequestBody UserDto user) throws IOException {
		return RestManagement.putResponse(PATH_ROOT, id, user);
	}

}
