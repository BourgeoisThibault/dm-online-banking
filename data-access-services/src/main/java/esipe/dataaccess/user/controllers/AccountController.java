package esipe.dataaccess.user.controllers;

import esipe.dataaccess.user.models.AccountDto;
import esipe.dataaccess.user.models.UserDto;
import esipe.dataaccess.user.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
