package esipe.clientmanagement.user.controllers;

import esipe.models.AccountDto;
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
 * Time     22:50
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

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createAccount(@RequestBody AccountDto accountDto) {

        AccountDto accountDtoNew = UserManagement.postMethode(PATH_ROOT, accountDto, AccountDto.class);

        return !(accountDtoNew == null) ?
                new ResponseEntity(accountDtoNew, HttpStatus.OK) : new ResponseEntity(new ErrorModel("Erreur de création"), HttpStatus.FORBIDDEN);
    }

}
