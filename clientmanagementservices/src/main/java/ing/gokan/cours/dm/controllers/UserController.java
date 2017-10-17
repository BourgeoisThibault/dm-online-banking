package ing.gokan.cours.dm.controllers;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for User
 *
 * @author BOURGEOIS Thibault
 * Date     16/10/2017
 * Time     22:13
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    /**
     * Method call with specific URL with GET
     * @return String
     */
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public String GetAll() {
        return "return of getall";
    }
}
