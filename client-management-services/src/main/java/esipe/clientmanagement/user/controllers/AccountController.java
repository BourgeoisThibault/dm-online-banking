package esipe.clientmanagement.user.controllers;

import esipe.models.AccountDto;
import esipe.restutils.RestManagement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author BOURGEOIS Thibault
 * Date     06/11/2017
 * Time     22:50
 */
@RestController
@RequestMapping(path = "/accounts")
public class AccountController {

    private String PATH_ROOT = "accounts/";

    @RequestMapping(path = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity getUserAccount(@PathVariable Long id) throws IOException {
        return RestManagement.getResponse(PATH_ROOT + "user/", id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createAccount(@RequestBody AccountDto accountDto) throws IOException {
        return RestManagement.postReponse(PATH_ROOT, accountDto);
    }

}
