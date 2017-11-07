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
 * Date     07/11/2017
 * Time     14:04
 */
@RestController
@RequestMapping(path = "/history")
public class HistoryController {

    private String PATH_ROOT = "history/";

    @RequestMapping(path = "/account/{id}", method = RequestMethod.GET)
    public ResponseEntity getAccountHistory(@PathVariable Long id) {

        //List<AccountDto> accountDtoList = UserManagement.getListMethode(PATH_ROOT + "user/" + id);

        //return (!accountDtoList.isEmpty()) ?
        //        new ResponseEntity(accountDtoList, HttpStatus.OK) : new ResponseEntity(new ErrorModel("Aucun comptes"),HttpStatus.FORBIDDEN);
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity getUserHistory(@PathVariable Long id) {

        //List<AccountDto> accountDtoList = UserManagement.getListMethode(PATH_ROOT + "user/" + id);

        //return (!accountDtoList.isEmpty()) ?
        //        new ResponseEntity(accountDtoList, HttpStatus.OK) : new ResponseEntity(new ErrorModel("Aucun comptes"),HttpStatus.FORBIDDEN);
    }
	
}
