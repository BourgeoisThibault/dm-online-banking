package esipe.dataaccess.user.controllers;

import esipe.dataaccess.user.services.UserService;
import esipe.models.*;
// import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author Gokan EKINCI
 */
@RestController
@RequestMapping(path = "/users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity getOneUser(@PathVariable @Valid @Pattern(regexp = "[0-9]{1,}") Long id) {

		try {
			UserDto userDto = userService.getUserById(id);
			return new ResponseEntity(userDto,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(new ErrorModel(e.getMessage()),HttpStatus.FORBIDDEN);
		}

	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity getAllUser() {

		final List<UserDto> userDtoList = userService.getAll();

		return (!userDtoList.isEmpty()) ?
			new ResponseEntity(userDtoList, HttpStatus.OK) : new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
		return new ResponseEntity<>(userService.create(user), HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity updateUser(@PathVariable Long id, @RequestBody UserDto user) {
		try {
			userService.update(id,user);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(new ErrorModel(e.getMessage()), HttpStatus.FORBIDDEN);
		}
	}

}
