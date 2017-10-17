package ing.gokan.cours.dm.services;

import ing.gokan.cours.dm.models.UserDto;
import ing.gokan.cours.dm.repositories.IUserDtoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author BOURGEOIS Thibault
 * Date     17/10/2017
 * Time     21:42
 */
@Service
public class UserDtoService implements IUserDtoService {

    private List<UserDto> myMockListUser = new ArrayList<UserDto>();

    @Override
    public List<UserDto> getAllUser() {
        return myMockListUser;
    }

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

    @Override
    public void addUser(UserDto userDto) {
        myMockListUser.add(userDto);
    }

    @Override
    public void updateUser(UserDto userDto,UserDto newUserDto) {
        for(int i=0; i<myMockListUser.size(); i++) {
            if(myMockListUser.get(i).getFirstName().equals(userDto.getFirstName()) &&
                    myMockListUser.get(i).getLastName().equals(userDto.getLastName())) {
                myMockListUser.get(i).setFirstName(newUserDto.getFirstName());
                myMockListUser.get(i).setLastName(newUserDto.getLastName());
            }
        }
    }

    @Override
    public void deleteUser(UserDto userDto) {
        for(int i=0; i<myMockListUser.size(); i++) {
            if(myMockListUser.get(i).getFirstName().equals(userDto.getFirstName()) &&
                    myMockListUser.get(i).getLastName().equals(userDto.getLastName())) {
                myMockListUser.remove(i);
            }
        }
    }

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
