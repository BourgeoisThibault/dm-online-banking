package esipe.clientmanagement.user.controllers;

import esipe.clientmanagement.user.models.UserDto;
// import org.springframework.data.domain.PageRequest;
import esipe.restutils.clientmanagement.UserManagement;
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
	public ResponseEntity<UserDto> get(@PathVariable Long id) {

		UserDto userDto = UserManagement.getMethode(PATH_ROOT, id, UserDto.class);

		return !(userDto == null) ?
			new ResponseEntity<>(userDto, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {

		final List<UserDto> userDtoList = UserManagement.getListMethode(PATH_ROOT);

		return (!userDtoList.isEmpty()) ?
			new ResponseEntity<>(userDtoList, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserDto> create(@RequestBody UserDto user) {

		UserDto userDto = UserManagement.postMethode(PATH_ROOT, user, UserDto.class);

		return !(userDto == null) ?
				new ResponseEntity<>(userDto, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UserDto user) {

		UserManagement.putMethode(PATH_ROOT, id, user);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/*
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {

		UserManagement.deleteMethode(PATH_ROOT, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	*/
}
