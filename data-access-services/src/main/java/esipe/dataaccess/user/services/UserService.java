package esipe.dataaccess.user.services;

import esipe.dataaccess.user.entities.UserEntity;
import esipe.models.*;
import esipe.dataaccess.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.dozer.DozerBeanMapper;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserService implements IUserService {

	DozerBeanMapper mapper = new DozerBeanMapper();

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<UserDto> getAll() {
		return userRepository.findAll()
				.stream()
				.map(
						u -> mapper.map(u, UserDto.class)
				)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<UserDto> getUserById(String id) {
		UserEntity userEntity = userRepository.findOne(Long.parseLong(id));
		return (userEntity != null) ?
				Optional.of(
						mapper.map(userEntity, UserDto.class)
				)
				: Optional.empty();
	}

	@Override
	public UserDto create(UserDto userDto) {

		UserEntity userEntity1 = userRepository.save(mapper.map(userDto,UserEntity.class));

		return mapper.map(userEntity1, UserDto.class);
	}

	@Override
	public void delete(Long id) {
		userRepository.delete(id);
	}

	@Override
	public void update(Long id, UserDto userDto) {

		Optional<UserDto> userBdd = this.getUserById(id.toString());

		if(userBdd.isPresent()) {
			UserEntity userEntity = new UserEntity();
			userEntity.setId(id);
			userEntity.setFirstName(userBdd.get().getFirstName());
			userEntity.setLastName(userBdd.get().getLastName());

			if(userDto.getAddress() != null)	{
				userEntity.setAddress(userDto.getAddress());
			} else {
				userEntity.setAddress(userBdd.get().getAddress());
			}
			if(userDto.getPhone() != null)	{
				userEntity.setPhone(userDto.getPhone());
			} else {
				userEntity.setPhone(userBdd.get().getPhone());
			}

			userRepository.save(userEntity);
		}
	}
}
