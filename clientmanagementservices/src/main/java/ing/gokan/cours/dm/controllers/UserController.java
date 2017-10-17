package ing.gokan.cours.dm.controllers;

import ing.gokan.cours.dm.models.UserDto;
import ing.gokan.cours.dm.repositories.IUserDtoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PathParam;
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
     * Method call with specific URL with GET
     * @return
     */
    @RequestMapping(value = "/getall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<UserDto> GetAllUser() {
        return userDtoService.getAllUser();
    }

    @RequestMapping(value = "/getbyfirstname", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<UserDto> GetUserByFirstName(@HeaderParam("firstname") String firstname) {
        return userDtoService.getUserByFirstName(firstname);
    }

    @RequestMapping(value = "/getbylastname", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<UserDto> GetUserByLastName(@HeaderParam("lastname") String lastname) {
        return userDtoService.getUserByLastName(lastname);
    }

    @RequestMapping(value = "/getbyuser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public UserDto GetUserByUser(@HeaderParam("firstname") String firstname, @HeaderParam("lastname") String lastname) {
        return userDtoService.getUserByUser(new UserDto(firstname,lastname));
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public String addUser(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) {
        if(userDtoService.contains(new UserDto(firstName, lastName))) {
            return "already exist";
        } else {
            userDtoService.addUser(new UserDto(firstName, lastName));
            return "goog job";
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public String deleteUser(@HeaderParam("firstname") String firstname, @HeaderParam("lastname") String lastname) {
        if(!userDtoService.contains(new UserDto(firstname, lastname))) {
            return "not exist";
        } else {
            userDtoService.deleteUser(new UserDto(firstname, lastname));
            return "goog job";
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String deleteUser(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName,
                             @RequestParam("newfirstname") String newFirstName, @RequestParam("newlastname") String newLastName) {
        if(!userDtoService.contains(new UserDto(firstName, lastName))) {
            return "not exist";
        } else {
            if(userDtoService.contains(new UserDto(newFirstName, newLastName))) {
                return "already exist";
            } else {
                userDtoService.updateUser(new UserDto(firstName, lastName), new UserDto(newFirstName,newLastName));
                return "goog job";
            }
        }
    }

}
