package esipe.clientmanagement.user.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import esipe.models.AccountDto;
import esipe.models.ErrorModel;
import esipe.restutils.RestManagement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
    public ResponseEntity getUserAccount(@PathVariable Long id) throws IOException {

        try {
            return RestManagement.getResponse(PATH_ROOT + "user/", id);
        } catch (Exception e) {
            ObjectMapper objectMapper = new ObjectMapper();
            ErrorModel errorModel = objectMapper.readValue(e.getMessage(),ErrorModel.class);
            return new ResponseEntity(errorModel,HttpStatus.FORBIDDEN);
        }

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createAccount(@RequestBody AccountDto accountDto) throws IOException {

        try {
            return RestManagement.postReponse(PATH_ROOT, accountDto);
        } catch (Exception e) {
            ObjectMapper objectMapper = new ObjectMapper();
            ErrorModel errorModel = objectMapper.readValue(e.getMessage(),ErrorModel.class);
            return new ResponseEntity(errorModel,HttpStatus.FORBIDDEN);
        }

    }

}
