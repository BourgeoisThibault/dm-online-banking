package ing.gokan.cours.dm.controllers;

import ing.gokan.cours.dm.models.UserDto;
import ing.gokan.cours.dm.repositories.IUserDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

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

    @Autowired
    private IUserDtoService userDtoService;

    /**
     * Method for get all users
     * @return list of UserDto formated to JSON
     */
    @RequestMapping(value = "/getall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<UserDto> GetAllUser() {
        return userDtoService.getAllUser();
    }

    /**
     * Method for get users with firstname
     * @param firstname
     * @return list of UserDto formated to JSON
     */
    @RequestMapping(value = "/getbyfirstname", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<UserDto> GetUserByFirstName(@HeaderParam("firstname") String firstname) {
        return userDtoService.getUserByFirstName(firstname);
    }

    /**
     * Method for get users with lastname
     * @param lastname
     * @return list of UserDto formated to JSON
     */
    @RequestMapping(value = "/getbylastname", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<UserDto> GetUserByLastName(@HeaderParam("lastname") String lastname) {
        return userDtoService.getUserByLastName(lastname);
    }

    /**
     * Method for get users with firstname and lastname
     * @param firstname
     * @param lastname
     * @return list of UserDto formated to JSON
     */
    @RequestMapping(value = "/getbyuser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public UserDto GetUserByUser(@HeaderParam("firstname") String firstname, @HeaderParam("lastname") String lastname) {
        return userDtoService.getUserByUser(new UserDto(firstname,lastname));
    }

    /**
     * Method for PUT (add) user in database (list)
     * @param firstName
     * @param lastName
     * @return success or error
     */
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public String addUser(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) {
        return userDtoService.addUser(new UserDto(firstName, lastName));
    }

    /**
     * Method for DELETE user from database (list)
     * @param firstname
     * @param lastname
     * @return success or error
     */
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public String deleteUser(@HeaderParam("firstname") String firstname, @HeaderParam("lastname") String lastname) {
        return userDtoService.deleteUser(new UserDto(firstname, lastname));
    }

    /**
     * Method for POST (modify) user from database (list)
     * @param firstName
     * @param lastName
     * @param newFirstName
     * @param newLastName
     * @return success or error
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String deleteUser(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName,
                             @RequestParam("newfirstname") String newFirstName, @RequestParam("newlastname") String newLastName) {
        return userDtoService.updateUser(new UserDto(firstName, lastName), new UserDto(newFirstName,newLastName));
    }

}
