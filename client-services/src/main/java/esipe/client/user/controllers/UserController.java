package esipe.client.user.controllers;

import esipe.models.ErrorModel;
import esipe.models.UserDto;
import esipe.restutils.RestManagement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author BOURGEOIS Thibault
 * Date     06/11/2017
 * Time     23:37
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {

    private String PATH_ROOT = "users/";

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getUser(@PathVariable Long id) {

        UserDto userDto = RestManagement.getMethode(PATH_ROOT, id, UserDto.class);

        return !(userDto == null) ?
                new ResponseEntity(userDto, HttpStatus.OK) : new ResponseEntity(new ErrorModel("User inconnu"),HttpStatus.FORBIDDEN);
    }



}
