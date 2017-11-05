package esipe.dataaccess.user.controllers;

import esipe.models.*;
import esipe.models.*;
import esipe.dataaccess.user.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     05/11/2017
 * Time     02:21
 */
@RestController
@RequestMapping(path = "/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<AccountDto> create(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.create(accountDto), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {

        final List<AccountDto> userDtoList = accountService.getAll();

        return (!userDtoList.isEmpty()) ?
                new ResponseEntity<>(userDtoList, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody AccountTransaction accountTransaction) {

        accountService.updateAccount(accountTransaction);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
