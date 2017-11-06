package esipe.dataaccess.user.services;

import esipe.models.*;

import java.util.List;
import java.util.Optional;

public interface IUserService {

	List<UserDto> getAll();

	UserDto getUserById(Long id) throws Exception;

	UserDto create(UserDto userDto);

	void delete(Long id);

	void update(Long id, UserDto userDto) throws Exception;
}
