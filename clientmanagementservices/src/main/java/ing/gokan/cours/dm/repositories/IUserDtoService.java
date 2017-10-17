package ing.gokan.cours.dm.repositories;

import ing.gokan.cours.dm.models.UserDto;

import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     17/10/2017
 * Time     21:42
 */
public interface IUserDtoService {
    public List<UserDto> getAllUser();
    public List<UserDto> getUserByFirstName(String fistName);
    public List<UserDto> getUserByLastName(String lastName);
    public UserDto getUserByUser(UserDto userDto);
    public void addUser(UserDto userDto);
    public void updateUser(UserDto userDto,UserDto newUserDto);
    public void deleteUser(UserDto userDto);

    public boolean contains(UserDto userDto);
}
