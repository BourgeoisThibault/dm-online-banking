package esipe.client.user.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import esipe.models.*;
import esipe.restutils.RestManagement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     07/11/2017
 * Time     14:04
 */
@RestController
@RequestMapping(path = "/history")
public class HistoryController {

    private String PATH_ROOT = "/";

    @RequestMapping(path = "/account/{id}", method = RequestMethod.GET)
    public ResponseEntity getAccountHistory(@PathVariable Long id) throws IOException {

        try {
            return RestManagement.getResponse(PATH_ROOT + "accounts/history/", id);
        } catch (Exception e) {
            ObjectMapper objectMapper = new ObjectMapper();
            ErrorModel errorModel = objectMapper.readValue(e.getMessage(),ErrorModel.class);
            return new ResponseEntity(errorModel,HttpStatus.FORBIDDEN);
        }

    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity getUserHistory(@PathVariable Long id) throws IOException {

        try {
            return RestManagement.getResponse(PATH_ROOT + "users/history/", id);
        } catch (Exception e) {
            ObjectMapper objectMapper = new ObjectMapper();
            ErrorModel errorModel = objectMapper.readValue(e.getMessage(),ErrorModel.class);
            return new ResponseEntity(errorModel,HttpStatus.FORBIDDEN);
        }

    }
	
}
