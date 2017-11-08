package esipe.dataaccess.user.controllers;

import esipe.dataaccess.user.services.HistoryService;
import esipe.dataaccess.user.services.UserService;
import esipe.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * @author Gokan EKINCI
 */
@RestController
@RequestMapping(path = "/users")
public class UserController {

	private final UserService userService;
	private final HistoryService historyService;

	@Autowired
	public UserController(UserService userService,
						  HistoryService historyService) {
		this.userService = userService;
		this.historyService = historyService;
	}

	/**
	 * Method for get information of one user
	 *
	 * @param id
	 * @return JSON
	 */
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity getOneUser(@PathVariable @Valid @Pattern(regexp = "[0-9]{1,}") Long id) {

		try {
			UserDto userDto = userService.getUserById(id);
			return new ResponseEntity(userDto,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(new ErrorModel(e.getMessage()),HttpStatus.FORBIDDEN);
		}

	}

	/**
	 * Method for get history of specifque user
	 *
	 * @param id
	 * @return JSON
	 */
	@RequestMapping(path = "/history/{id}", method = RequestMethod.GET)
	public ResponseEntity getHistoryAccountOfUser(@PathVariable Long id) {

		try {
			UserDto userDto = userService.getUserById(id);
			if(userDto == null)
				return new ResponseEntity(new ErrorModel("User inconnu"),HttpStatus.FORBIDDEN);
			List<HistoryDto> historyDtoList = historyService.getAllByUserId(userDto);
			return (!historyDtoList.isEmpty()) ?
					new ResponseEntity(historyDtoList, HttpStatus.OK) : new ResponseEntity(new ErrorModel("Aucun résultat"), HttpStatus.FORBIDDEN);
		} catch (Exception e) {
			return new ResponseEntity(new ErrorModel(e.getMessage()),HttpStatus.FORBIDDEN);
		}
	}

	/**
	 *
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity getAllUser() {

		final List<UserDto> userDtoList = userService.getAll();

		return (!userDtoList.isEmpty()) ?
			new ResponseEntity(userDtoList, HttpStatus.OK) : new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	/**
	 *
	 * @param user
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
		return new ResponseEntity<>(userService.create(user), HttpStatus.OK);
	}

	/**
	 *
	 * @param id
	 * @param user
	 * @return
	 */
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
