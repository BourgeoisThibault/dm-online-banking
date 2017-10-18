package ing.gokan.cours.dm.repositories;

import ing.gokan.cours.dm.models.UserDto;
import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     17/10/2017
 * Time     21:42
 */
public interface IUserDtoService {

    /**
     * Get all users
     * @return list
     */
    public List<UserDto> getAllUser();

    /**
     * Search with firstname and return result
     * @param fistName
     * @return
     */
    public List<UserDto> getUserByFirstName(String fistName);

    /**
     * Search with lastname and return result
     * @param lastName
     * @return
     */
    public List<UserDto> getUserByLastName(String lastName);

    /**
     * Search with firstname ans lastname and return result
     * @param userDto
     * @return
     */
    public UserDto getUserByUser(UserDto userDto);

    /**
     * Add in list if not existing
     * @param userDto
     * @return result
     */
    public String addUser(UserDto userDto);

    /**
     * Change in list in exist and if nex not existing
     * @param userDto
     * @param newUserDto
     * @return result
     */
    public String updateUser(UserDto userDto,UserDto newUserDto);

    /**
     * Delete from list if exist
     * @param userDto
     * @return reuslt
     */
    public String deleteUser(UserDto userDto);

    public boolean contains(UserDto userDto);
}
