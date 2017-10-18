package ing.gokan.cours.dm.services;

import ing.gokan.cours.dm.models.UserDto;
import ing.gokan.cours.dm.repositories.IUserDtoService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     17/10/2017
 * Time     21:42
 */
@Service
public class UserDtoService implements IUserDtoService {

    private List<UserDto> myMockListUser = new ArrayList<UserDto>();

    /**
     * Get all users
     * @return list
     */
    @Override
    public List<UserDto> getAllUser() {
        return myMockListUser;
    }

    /**
     * Search with firstname and return result
     * @param fistName
     * @return
     */
    @Override
    public List<UserDto> getUserByFirstName(String fistName) {
        List<UserDto> returnList = new ArrayList<UserDto>();
        for(int i=0; i<myMockListUser.size(); i++) {
            if(myMockListUser.get(i).getFirstName().equals(fistName)) {
                returnList.add(myMockListUser.get(i));
            }
        }
        return returnList;
    }

    /**
     * Search with lastname and return result
     * @param lastName
     * @return
     */
    @Override
    public List<UserDto> getUserByLastName(String lastName) {
        List<UserDto> returnList = new ArrayList<UserDto>();
        for(int i=0; i<myMockListUser.size(); i++) {
            if(myMockListUser.get(i).getLastName().equals(lastName)) {
                returnList.add(myMockListUser.get(i));
            }
        }
        return returnList;
    }

    /**
     * Search with firstname ans lastname and return result
     * @param userDto
     * @return
     */
    @Override
    public UserDto getUserByUser(UserDto userDto) {
        for(int i=0; i<myMockListUser.size(); i++) {
            if(myMockListUser.get(i).getFirstName().equals(userDto.getFirstName()) &&
                    myMockListUser.get(i).getLastName().equals(userDto.getLastName())) {
                return myMockListUser.get(i);
            }
        }
        return new UserDto(null,null);
    }

    /**
     * Add in list if not existing
     * @param userDto
     * @return result
     */
    @Override
    public String addUser(UserDto userDto) {
        if(contains(userDto)) {
            return "ERROR : " + userDto.toString()+ " already exist";
        } else {
            myMockListUser.add(userDto);
            return "PUT : " + userDto.toString();
        }
    }

    /**
     * Change in list in exist and if nex not existing
     * @param userDto
     * @param newUserDto
     * @return result
     */
    @Override
    public String updateUser(UserDto userDto,UserDto newUserDto) {
        if(!contains(userDto)) {
            return "ERROR : " + userDto.toString()+ " not exist";
        } else {
            if(contains(newUserDto)) {
                return "ERROR : " + newUserDto.toString()+  " already exist";
            } else {
                for(int i=0; i<myMockListUser.size(); i++) {
                    if(myMockListUser.get(i).getFirstName().equals(userDto.getFirstName()) &&
                            myMockListUser.get(i).getLastName().equals(userDto.getLastName())) {
                        myMockListUser.get(i).setFirstName(newUserDto.getFirstName());
                        myMockListUser.get(i).setLastName(newUserDto.getLastName());
                    }
                }
                return "POST : " + userDto.toString() + " TO " + newUserDto.toString();
            }
        }
    }

    /**
     * Delete from list if exist
     * @param userDto
     * @return reuslt
     */
    @Override
    public String deleteUser(UserDto userDto) {
        if(!contains(userDto)) {
            return "ERROR : " + userDto.toString() + " not exist";
        } else {
            for(int i=0; i<myMockListUser.size(); i++) {
                if(myMockListUser.get(i).getFirstName().equals(userDto.getFirstName()) &&
                        myMockListUser.get(i).getLastName().equals(userDto.getLastName())) {
                    myMockListUser.remove(i);
                }
            }
            return "DELETE : " + userDto.toString();
        }

    }

    /**
     * Looking if exist in list
     * @param userDto
     * @return true/false
     */
    @Override
    public boolean contains(UserDto userDto) {
        for(int i=0; i<myMockListUser.size(); i++) {
            if(myMockListUser.get(i).getFirstName().equals(userDto.getFirstName()) &&
                    myMockListUser.get(i).getLastName().equals(userDto.getLastName())) {
                return true;
            }
        }
        return false;
    }
}
