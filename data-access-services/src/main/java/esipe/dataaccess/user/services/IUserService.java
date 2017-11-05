package esipe.dataaccess.user.services;

import esipe.dataaccess.user.models.UserDto;

import java.util.List;
import java.util.Optional;

public interface IUserService {

	List<UserDto> getAll();

	Optional<UserDto> getUserById(String id);

	UserDto create(UserDto userDto);

	void delete(Long id);

	void update(Long id, UserDto userDto);
}
