package esipe.client.user.controllers;

import esipe.restutils.RestManagement;
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
        return RestManagement.getResponse(PATH_ROOT, id);
    }



}
