package esipe.dataaccess.user.services;

import esipe.dataaccess.user.entities.UserEntity;
import esipe.dataaccess.user.repositories.UserRepository;
import esipe.models.UserDto;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

/**
 * @author BOURGEOIS Thibault
 * Date     07/11/2017
 * Time     21:01
 */
public class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        // Given
        List<UserEntity> userEntityList = new ArrayList<UserEntity>();

        UserEntity userEntity = new UserEntity();
        userEntity.setId(Long.parseLong("1"));
        userEntity.setLastName("lastName");
        userEntity.setFirstName("firstname");
        userEntity.setPhone("phone");
        userEntity.setAddress("adresse");
        userEntity.setBirth(new Date(System.currentTimeMillis()));

        userEntityList.add(userEntity);
        userEntityList.add(userEntity);
        userEntityList.add(userEntity);

        when(userRepository.findOne(anyLong())).thenReturn(userEntity);

        when(userRepository.findAll()).thenReturn(userEntityList);

        when(userRepository.save(userEntity)).thenReturn(null);
    }

    @Test
    public void getAllTest() throws Exception {
        List<UserDto> userDtoList = userService.getAll();

        assertTrue(userDtoList.get(0).getPhone().equals("phone"));
    }

    @Test
    public void getUserById() throws Exception {
        UserDto userDto = userService.getUserById(anyLong());

        assertTrue(userDto.getPhone().equals("phone"));
    }

    @Test
    public void update() throws Exception {

        UserDto userDto = new UserDto();
        userDto.setId(Long.parseLong("1"));
        userDto.setLastName("lastName");
        userDto.setFirstName("new");
        userDto.setPhone("phone");
        userDto.setAddress("new");
        userDto.setBirth(new Date(System.currentTimeMillis()));

        userService.update(anyLong(),userDto);

        UserDto userDtoNew = userService.getUserById(anyLong());

        assertTrue(userDtoNew.getPhone().equals(userDto.getPhone()));
        assertFalse(userDtoNew.getFirstName().equals(userDto.getFirstName()));

    }

}