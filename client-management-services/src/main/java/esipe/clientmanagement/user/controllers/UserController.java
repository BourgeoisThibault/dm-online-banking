package esipe.clientmanagement.user.controllers;

// import org.springframework.data.domain.PageRequest;
import esipe.restutils.RestManagement;
import esipe.models.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Gokan EKINCI
 */
@RestController
@RequestMapping(path = "/users")
public class UserController {

	private String PATH_ROOT = "users/";

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity getUser(@PathVariable Long id) {

		UserDto userDto = RestManagement.getMethode(PATH_ROOT, id, UserDto.class);

		return !(userDto == null) ?
			new ResponseEntity(userDto, HttpStatus.OK) : new ResponseEntity(new ErrorModel("User inconnu"),HttpStatus.FORBIDDEN);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity getAllUser() {

		final List<UserDto> userDtoList = RestManagement.getListMethode(PATH_ROOT);

		return (!userDtoList.isEmpty()) ?
			new ResponseEntity(userDtoList, HttpStatus.OK) : new ResponseEntity(new ErrorModel("Aucun user"), HttpStatus.FORBIDDEN);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity createUser(@RequestBody UserDto user) {

		UserDto userDto = RestManagement.postMethode(PATH_ROOT, user, UserDto.class);

		return !(userDto == null) ?
				new ResponseEntity(userDto, HttpStatus.OK) : new ResponseEntity(new ErrorModel("Erreur de création"), HttpStatus.FORBIDDEN);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity updateUser(@PathVariable Long id, @RequestBody UserDto user) {

		RestManagement.putMethode(PATH_ROOT, id, user);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
