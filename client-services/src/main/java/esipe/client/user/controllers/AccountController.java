package esipe.client.user.controllers;

import esipe.models.AccountDto;
import esipe.models.AccountTransaction;
import esipe.models.ErrorModel;
import esipe.models.UserDto;
import esipe.restutils.clientmanagement.UserManagement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     06/11/2017
 * Time     23:38
 */
@RestController
@RequestMapping(path = "/accounts")
public class AccountController {

    private String PATH_ROOT = "accounts/";

    @RequestMapping(path = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity getUserAccount(@PathVariable Long id) {

        List<AccountDto> accountDtoList = UserManagement.getListMethode(PATH_ROOT + "user/" + id);

        return (!accountDtoList.isEmpty()) ?
                new ResponseEntity(accountDtoList, HttpStatus.OK) : new ResponseEntity(new ErrorModel("Aucun comptes"),HttpStatus.FORBIDDEN);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateUser(@RequestBody AccountTransaction accountTransaction) {

        UserManagement.putMethode(PATH_ROOT, null, accountTransaction);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
