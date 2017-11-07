package esipe.client.user.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import esipe.models.ErrorModel;
import esipe.models.UserDto;
import esipe.restutils.RestManagement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

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
    public ResponseEntity getUser(@PathVariable Long id) throws IOException {

        try {
            return RestManagement.getResponse(PATH_ROOT, id);
        } catch (Exception e) {
            ObjectMapper objectMapper = new ObjectMapper();
            ErrorModel errorModel = objectMapper.readValue(e.getMessage(),ErrorModel.class);
            return new ResponseEntity(errorModel,HttpStatus.FORBIDDEN);
        }

    }



}
