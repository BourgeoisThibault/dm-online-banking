package esipe.dataaccess.user.controllers;

import esipe.dataaccess.user.services.HistoryService;
import esipe.models.*;
import esipe.dataaccess.user.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    private final HistoryService historyService;

    @Autowired
    public AccountController(AccountService accountService,
                             HistoryService historyService) {
        this.accountService = accountService;
        this.historyService = historyService;
    }

    /**
     * Method for create new account
     *
     * @param accountDto
     * @return JSON
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createAccount(@RequestBody AccountDto accountDto) {
        try {
            AccountDto accountDtoReturn = accountService.create(accountDto);
            return new ResponseEntity(accountDtoReturn, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new ErrorModel(e.getMessage()),HttpStatus.FORBIDDEN);
        }
    }

    /**
     * Method for get all account for one specifique user
     *
     * @param id
     * @return JSON
     */
    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity getAllAccountOfUser(@PathVariable Long id) {

        final List<AccountDto> userDtoList;
        try {
            userDtoList = accountService.getAllAccountOfUser(id);
            return (!userDtoList.isEmpty()) ?
                    new ResponseEntity(userDtoList, HttpStatus.OK) : new ResponseEntity(new ErrorModel("Aucun résultat"), HttpStatus.FORBIDDEN);
        } catch (Exception e) {
            return new ResponseEntity(new ErrorModel(e.getMessage()),HttpStatus.FORBIDDEN);
        }
    }

    /**
     * Method for get history of specifique account
     *
     * @param id
     * @return JSON
     */
    @RequestMapping(path = "/history/{id}", method = RequestMethod.GET)
    public ResponseEntity getHistoryOfOneAccount(@PathVariable Long id) {

        try {
            List<HistoryDto> historyDtoList = historyService.getAllByAccountId(id);
            return (!historyDtoList.isEmpty()) ?
                    new ResponseEntity(historyDtoList, HttpStatus.OK) : new ResponseEntity(new ErrorModel("Aucun résultat"), HttpStatus.FORBIDDEN);
        } catch (Exception e) {
            return new ResponseEntity(new ErrorModel(e.getMessage()),HttpStatus.FORBIDDEN);
        }
    }

    /**
     * Method for put transaction for update account and history transation
     *
     * @param accountTransaction
     * @return JSON
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody AccountTransaction accountTransaction) {
        try {
            accountService.updateAccount(accountTransaction);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new ErrorModel(e.getMessage()),HttpStatus.FORBIDDEN);
        }
    }

}
